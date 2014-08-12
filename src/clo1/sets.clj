(def stooges (hash-set "Moe" "Larry" "Curly"))

(def stooges #{"Moe" "Larry" "Curly"})

(def stooges (sorted-set "Moe" "Larry" "Curly"))

stooges

(contains? stooges "Moe")

(contains? stooges "Mark")

(stooges "Moe")

(stooges "Mark")

(conj stooges "Shemp")

(cons "Shemp" stooges)

(disj stooges "Larry")

(.toUpperCase "Larry")

