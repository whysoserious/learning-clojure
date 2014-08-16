(clojure.string/join "-" [1 2 3])

(require 'clojure.string)

(refer 'clojure.string)

(join "," [1 2 3])

(use 'clojure.string)

(comment
  (ns com.ociweb.demo
    (:require [clojure.string :as su])
    ; assumes this dependency: [org.clojure/math.numeric-tower "0.0.1"]
    (:use [clojure.math.numeric-tower :only (gcd, sqrt)])
    (:import (java.text NumberFormat) (javax.swing JFrame JLabel)))

  (println (su/join "$" [1 2 3])) ; -> 1$2$3
  (println (gcd 27 72)) ; -> 9
  (println (sqrt 5)) ; -> 2.23606797749979
  (println (.format (NumberFormat/getInstance) Math/PI)) ; -> 3.142

  ; See the screenshot that follows this code.
  (doto (JFrame. "Hello")
    (.add (JLabel. "Hello, World!"))
    (.pack)
    (.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE)
    (.setVisible true)))

(def foo 1)

(create-ns 'com.ociweb.demo)

(intern 'com.ociweb.demo 'foo 4)

(+ foo com.ociweb.demo/foo)

(ns-interns 'com.ociweb.demo)

