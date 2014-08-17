;; Vars

(def y 1)

y

(println "--------------------------")

(def ^:dynamic v 1)

(defn change-it []
  (println "2) v =" v) ; -> 1

  (def v 2) ; changes root value
  (println "3) v =" v) ; -> 2

  (binding [v 3] ; binds a thread-local value
    (println "4) v =" v) ; -> 3

    (set! v 4) ; changes thread-local value
    (println "5) v =" v)) ; -> 4

  (println "6) v =" v)) ; thread-local value is gone now -> 2

(println "1) v =" v) ; -> 1

(let [thread (Thread. #(change-it))]
  (.start thread)
  (.join thread)) ; wait for thread to finish

(println "7) v =" v)

;; Refs

(println "--------------------------")

(def z (ref 1))

;; (ref-set z 3)

(dosync
 (def i (deref z))
 (ref-set z (inc i)))

(dosync (ref-set z (inc @z)))

(def i (deref z))

i

(dosync
 (alter z inc)
 (commute z inc))
