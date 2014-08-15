(map #(println %) [1 2 3])

(println "-----------------------------")

(dorun (map #(println %) [1 2 3]))

(println "-----------------------------")

(doall (map #(println %) [1 2 3]))

(println "-----------------------------")

(doseq [i [1 2 3]] (println i))

(println "-----------------------------")

(defn f [x] (/ (* x x) 2.0))

(f 3)

(def f-seq (map f (iterate inc 0)))

(take 10 f-seq)

f-seq

(def f-seq-2 (map f (iterate inc 0)))

f-seq-2

(defn consumer [seq]
  ; Since seq is a local binding, the evaluated items in it
  ; are cached while in this function and then garbage collected.
  (println (first seq)) ; evaluates (f 0)
  (println (nth seq 2))) ; evaluates (f 1) and (f 2)

(consumer (map f (iterate inc 0)))






