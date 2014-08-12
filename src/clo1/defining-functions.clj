(defn parting
  "returns a String parting"
  [name]
  (str "Goodbye, " name))

(parting "Mark")

(declare parting)

;; Functions defined with the defn- macro are private. This means they are only visible in the namespace in which they are defined.

(defn power [base & exponents]
  ; Using java.lang.Math static method pow.
  (reduce #(Math/pow %1 %2) base exponents))

(power 2 3 4)

(defn parting
  "returns a String parting in a given language"
  ([] (parting "World"))
  ([name] (parting name "en"))
  ([name language]
    ; condp is similar to a case statement in other languages.
    ; It is described in more detail later.
    ; It is used here to take different actions based on whether the
    ; parameter "language" is set to "en", "es" or something else.
    (condp = language
      "en" (str "Goodbye, " name)
      "es" (str "Adios, " name)
      (throw (IllegalArgumentException.
        (str "unsupported language " language))))))

(parting)
(parting "Mark")
(parting "Mark" "es")
;; (parting "Mark", "xy")

(def years [1940 1944 1961 1985 1987])

(filter (fn [year] (even? year)) years)

(filter #(even? %) years)

(filter even? years)

(defn pair-test [test-fn n1 n2]
  (if (test-fn n1 n2) "pass" "fail"))

(pair-test #(even? (+ %1 %2)) 3 5)

(defmulti what-i-am class)

(defmethod what-i-am Number [arg] (str arg "is a Number"))
(defmethod what-i-am String [arg] (str arg "is a String"))
(defmethod what-i-am :default [arg] (str arg "is something else"))
(what-i-am 19)
(what-i-am "Hello")
(what-i-am true)

(defn callback1 [n1 n2 n3] (+ n1 n2 n3))
(defn callback2 [n1 _ n3] (+ n1 n3))
(defn caller [callback value]
  (callback (+ value 1) (+ value 2) (+ value 3)))
(caller callback1 10)
(caller callback2 10)

(defn teenager? [age] (and (< age 13) (> age 20)))
(def non-teen? (complement what-i-am))
(non-teen? 7)

;; comp

(defn times2 [n] (* n 2))

(defn minus3 [n] (- n 3))

(def my-composition (comp minus3 times2))

(my-composition 4)

;; partial

(def times3 (partial * 3))

(times3 4 5)

(apply + '(1 2 3))

(defn- polynomial
  "computes the value of a polynomial
   with the given coefficients for a given value x"
  [coefs x]
  ; For example, if coefs contains 3 values then exponents is (2 1 0).
  (let [exponents (reverse (range (count coefs)))]
    ; Multiply each coefficient by x raised to the corresponding exponent
    ; and sum those results.
    ; coefs go into %1 and exponents go into %2.
    (apply + (map #(* %1 (Math/pow x %2)) coefs exponents))))

(defn- derivative
  "computes the value of the derivative of a polynomial
   with the given coefficients for a given value x"
  [coefs x]
  ; The coefficients of the derivative function are obtained by
  ; multiplying all but the last coefficient by its corresponding exponent.
  ; The extra exponent will be ignored.
  (let [exponents (reverse (range (count coefs)))
        derivative-coefs (map #(* %1 %2) (butlast coefs) exponents)]
    (polynomial derivative-coefs x)))

(def f (partial polynomial [2 1 3])) ; 2x^2 + x + 3
(def f-prime (partial derivative [2 1 3])) ; 4x + 1

(println "f(2) =" (f 2)) ; -> 13.0
(println "f'(2) =" (f-prime 2)) ; -> 9.0

(def memo-f (memoize f))

(time (f 2))

(dotimes [_ 3] (time (f 2)))

(dotimes [_ 3] (time (memo-f 2)))






