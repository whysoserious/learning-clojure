(defn approach1 [numbers]
  (let [n1 (first numbers)
        n3 (nth numbers 2)]
    (+ n1 n3)))

(approach1 [1 2 3 4])

(approach1 '(1 2 3 4))

(defn approach2 [[n1 _ n3]]
  (+ n1 n3))

(approach2 [1 2 3 4])

;; (approach2 [1])

(defn name-summary [n1 n2 & others]
  (str n1 ", " n2 " and " (count others) " others"))

(name-summary "me" "you" "a" "b" "c")

;; (name-summary [])

(defn first-and-third-percentage [[n1 _ n3 :as coll]]
  (/ (+ n1 n3) (apply + coll)))

(first-and-third-percentage [1 2 3 4])

(defn summer-sales-percentages [{:keys [june july august] :as all}]
  (let [summer-sales (+ june july august)
        all-sales (apply + (vals all))]
    (/ summer-sales all-sales)))

(def sales {
  :january   100 :february 200 :march      0 :april    300
  :may       200 :june     100 :july     400 :august   500
  :september 200 :october  300 :november 400 :december 600})

(summer-sales-percentages sales)

