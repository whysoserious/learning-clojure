(defstruct card-struct :rank :suit)

(def card1 (struct card-struct :king :club))

(def card2 (struct card-struct :king :club))

(identical? card1 card2)

(= card1 card2)

(def card2 ^{:bent true} card2)

(def card2 (with-meta card2 {:bent true :dupa false}))

(meta card1)

(meta card2)

(= card1 card2)

(println (meta (var reverse)))

(source reverse)


