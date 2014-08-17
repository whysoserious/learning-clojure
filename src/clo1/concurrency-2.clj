(ns com.ociweb.bank)

; Assume the only account data that can change is its balance.
(defstruct account-struct :id :owner :balance-ref)

; We need to be able to add and delete accounts to and from a map.
; We want it to be sorted so we can easily
; find the highest account number
; for the purpose of assigning the next one.
(def account-map-ref (ref (sorted-map)))

(defn open-account
  "creates a new account, stores it in the account map and returns it"
  [owner]
  (dosync ; required because a Ref is being changed
   (let [account-map @account-map-ref
         last-entry (last account-map)
         ; The id for the new account is one higher than the last one.
         id (if last-entry (inc (key last-entry)) 1)
         ; Create the new account with a zero starting balance.
         account (struct account-struct id owner (ref 0))]
     ; Add the new account to the map of accounts.
     (alter account-map-ref assoc id account)
     ; Return the account that was just created.
     account)))

(defn deposit [account amount]
  "adds money to an account; can be a negative amount"
  (dosync ; required because a Ref is being changed
   (Thread/sleep 50) ; simulate a long-running operation
   (let [owner (account :owner)
         balance-ref (account :balance-ref)
         type (if (pos? amount) "deposit" "withdraw")
         direction (if (pos? amount) "to" "from")
         abs-amount (Math/abs amount)]
     (if (>= (+ @balance-ref amount) 0) ; sufficient balance?
       (do
         (alter balance-ref + amount)
         (println (str type "ing") abs-amount direction owner))
       (throw (IllegalArgumentException.
               (str "insufficient balance for " owner
                    " to withdraw " abs-amount)))))))

(defn withdraw
  "removes money from an account"
  [account amount]
  ; A withdrawal is like a negative deposit.
  (deposit account (- amount)))

(defn transfer [from-account to-account amount]
  (dosync
   (println "transferring" amount
            "from" (from-account :owner)
            "to" (to-account :owner))
   (withdraw from-account amount)
   (deposit to-account amount)))

(defn- report-1 ; a private function
  "prints information about a single account"
  [account]
  ; This assumes it is being called from within
  ; the transaction started in report.
  (let [balance-ref (account :balance-ref)]
    (println "balance for" (account :owner) "is" @balance-ref)))

(defn report
  "prints information about any number of accounts"
  [& accounts]
  (dosync (doseq [account accounts] (report-1 account))))

; Set a default uncaught exception handler
; to handle exceptions not caught in other threads.
(Thread/setDefaultUncaughtExceptionHandler
 (proxy [Thread$UncaughtExceptionHandler] []
   (uncaughtException [thread throwable]
                      ; Just print the message in the exception.
                      (println (.. throwable .getCause .getMessage)))))

(let [a1 (open-account "Mark")
      a2 (open-account "Tami")
      thread (Thread. #(transfer a1 a2 50))]
  (try
    (deposit a1 100)
    (deposit a2 200)

    ; There are sufficient funds in Mark's account at this point
    ; to transfer $50 to Tami's account.
    (.start thread) ; will sleep in deposit function twice!

    ; Unfortunately, due to the time it takes to complete the transfer
    ; (simulated with sleep calls), the next call will complete first.
    (withdraw a1 75)

    ; Now there are insufficient funds in Mark's account
    ; to complete the transfer.

    (.join thread) ; wait for thread to finish
    (report a1 a2)
    (catch IllegalArgumentException e
      (println (.getMessage e) "in main thread"))))


; Note the use of the :validator directive when creating the Ref
; to assign a validation function which is integer? in this case.
(def my-ref (ref 0 :validator integer?))

(try
  (dosync
   (ref-set my-ref 1) ; works

   ; The next line doesn't work, so the transaction is rolled back
   ; and the previous change isn't committed.
   (ref-set my-ref "foo"))
  (catch IllegalStateException e
    ; do nothing
    ))

(println "my-ref =" @my-ref) ; due to validation failure -> 0






