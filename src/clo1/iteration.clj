(dotimes [card-number 3]
  (println (str "Card number: "card-number)))

(println "-----------------------------------")

(defn my-fn [ms]
  (println "START")
  (Thread/sleep ms)
  (println "STOP"))

(let [thread (Thread. #(my-fn 1))]
  (.start thread)
  (while (.isAlive thread)
    (print ".")
    (flush)))

(println "-----------------------------------")

(def cols "ABCD")

(def rows (range 1 4))


(for [col cols :when (not= col \B)
      row rows :while (< row 3)]
  (str col row))

(println "-----------------------------------")

(doseq [col cols :when (not= col \B)
        row rows :while (< row 3)]
  (println (str col row)))

(println "-----------------------------------")

(defn factorial-1 [number]
  (loop [n number factorial 1]
    (if (zero? n)
      factorial
      (recur (dec n) (* factorial n)))))

(println (time (factorial-1 10)))

(println "-----------------------------------")

