(count [1 "asdf", ()])

(reverse [])

(reverse [1 2 3])

(map #(* % %) [1 2 3])

(apply + 4 5 6 7 9 '(1 2 3))

(def stooges ["Moe" "Larry" "Curly" "Shemp"])

(first stooges)

(second stooges)

(rest stooges)

(last stooges)

(nth stooges 2)

(next stooges)

(rest [])

(next [])

(butlast stooges)

(butlast [])

(drop-last 666 stooges)

(drop-last 2 stooges)

(filter #(> (count %) 3) stooges)

(nthnext stooges 2)

(def stooges (list "Moe" "Larry" "Curly"))

(def stooges (quote ("Moe" "Larry" "Curly")))

(def stooges '("Moe" "Larry" "Curly"))

(some #(= % "Larry") stooges)

(contains? (set stooges) "Moe")

(conj stooges "Andy" "Randy")

(cons "Andy" stooges)

(remove #(= % "Curly") stooges)

(into stooges stooges)

(peek stooges)

(pop stooges)

(def kids-of-mike '("Greg" "Peter" "Bobby"))

(def kids-of-carol '("Marcia" "Jan" "Cindy"))

(into kids-of-mike kids-of-carol)
