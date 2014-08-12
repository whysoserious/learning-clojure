(def popsicle-map
  (hash-map :red :cherry, :green :apple, :purple :grape))

(def popsicle-map
  {:red :cherry, :green :apple, :purple :grape})

(def popsicle-map
  (sorted-map :red :cherry, :green :apple, :purple :grape))

popsicle-map

(get popsicle-map :green)

(popsicle-map :green)

(:green popsicle-map)

(:dupa popsicle-map)

(contains? popsicle-map :green)

(contains? popsicle-map :grape)

(keys popsicle-map)

(vals popsicle-map)

(assoc popsicle-map :green :lime :blue :blueberry)

(dissoc popsicle-map :green :blue)

(doseq [[color flavor] popsicle-map]
  (println (str "The color of " (name color) " popsicles is " (name flavor))))

(select-keys popsicle-map [:red :green :blue])

(def person {
  :name "Mark Volkmann"
  :address {
    :street "644 Glen Summit"
    :city "St. Charles"
    :state "Missouri"
    :zip 63304}
  :employer {
    :name "Object Computing, Inc."
    :address {
      :street "12140 Woodcrest Executive Drive, Suite 250"
      :city "Creve Coeur"
      :state "Missouri"
      :zip 63141}}})

(get-in person [:employer :address :city])

;; "thread" macro
;; (f1 (f2 (f3 x)))
;; (-> x f3 f2 f1)

(-> person :employer :address :city)

(get person :employer)

(reduce get person [:employer :address :city])

(assoc-in person [:employer :address :city] "Clayton")















