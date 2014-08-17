(def my-atom (atom 1))

(reset! my-atom 2)

@my-atom

(defn update-atom []
  (let [curr-val @my-atom]
    (println "update-atom: curr-val =" curr-val) ; -> 1
    (Thread/sleep 50) ; give reset! time to run
    (println
      (compare-and-set! my-atom curr-val (inc curr-val))))) ; -> false

(let [thread (Thread. #(update-atom))]
  (.start thread)
  (Thread/sleep 25) ; give thread time to call update-atom
  (reset! my-atom 3) ; happens after update-atom binds curr-val
  (.join thread)) ; wait for thread to finish

@my-atom ; -> 3

