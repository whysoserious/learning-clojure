;; The peek and pop functions also work with vectors, but operate on the end or tail rather than the beginning or head as they do for lists. The conj function creates a new vector that contains an additional item added to the back. The cons function creates a new vector that contains an additional item added to the front.

(def stooges (vector "Moe" "Larry" "Curly"))

(def stooges ["Moe" "Larry" "Curly"])

(nth stooges 2)

(nth stooges 3 "Dupa")

(get stooges 3 "Dupa")

(assoc stooges 2 "Shemp")

