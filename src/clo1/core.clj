(ns clo1.core)

(defn foo
  "I don't do a whole lot."
  [x]

  (println x "Hello, World!"))

(def vowel? (set "aeiou"))

(defn pig-latin [word] ; defines a function
  "asdfasdfasdf"
  ; word is expected to be a string
  ; which can be treated like a sequence of characters.
  (let [first-letter (first word)] ; assigns a local binding
    (if (vowel? first-letter)
      (str word "ay") ; then part of if
      (str (subs word 1) first-letter "ay")))) ; else part of if

(pig-latin "red")
(pig-latin "orange")

(pig-latin "asdfasdfasd")

(def ^:dynamic v 1)

(defn f1 []
  v)

(defn f2 []
  (let [v 2]
    (f1)))

(defn f3 []
  (binding [v 3]
    (f1)))

(defn f4 []
  (def v 4))

(f1)

(= v 1)
(f2)
(= v 1)
(f3)
(= v 1)
(f4)
(= v 4)






