(import '(java.util Calendar GregorianCalendar))

(let
  [gc (GregorianCalendar.)
   day-of-week (.get gc Calendar/DAY_OF_WEEK)
   is-weekend (or (= day-of-week Calendar/SATURDAY) (= day-of-week Calendar/SUNDAY))]
  (if is-weekend
    '("play")
    '("work/sleep"))
  (when is-weekend (println "play"))
  (when-not is-weekend (println "work") (println "sleep")))

(defn process-next [waiting-line]
  (if-let [name (first waiting-line)]
    (str name " is next")
    '("no waiting")))

(process-next '("a" "b"))

(process-next '())

(defn summarize
  "prints the first item in a collection
  followed by a period for each remaining item"
  [coll]
  ; Execute the when-let body only if the collection isn't empty.
  (when-let [head (first coll)]
    (print head)
    ; Below, dec subtracts one (decrements) from
    ; the number of items in the collection.
    (dotimes [_ (dec (count coll))] (print \.))
    (println)))

(summarize ["Moe" "Larry" "Curly"]) ; -> Moe..
(summarize []) ; -> no output

(defn print-a-number [line]
  (let [value (try
                (Integer/parseInt line)
                (catch NumberFormatException e line))]
    (condp = value
      1 "one"
      2 "two"
      3 "three"
      (str "unexpected value: " value))
    ))

(print-a-number "2")

(print-a-number "44")

(defn print-a-number2 [line]
  (let [value (try
                (Integer/parseInt line)
                (catch NumberFormatException e line))]
    (condp instance? value
      Number (* value 2)
      String (* (count value) 2))))

(print-a-number2 "2")








