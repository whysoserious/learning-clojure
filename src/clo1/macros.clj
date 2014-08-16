((meta (var and)) :macro)

((meta #'and) :macro)

((meta #'defn) :macro)

(defmacro around-zero [number negative-expr zero-expr positive-expr]
  `(let [number# ~number] ; so number is only evaluated once
    (cond
      (< (Math/abs number#) 1e-15) ~zero-expr
      (pos? number#) ~positive-expr
      true ~negative-expr)))

(around-zero 0.1 "-" "0" "+")

