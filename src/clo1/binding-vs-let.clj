(def ^:dynamic x 0)

(binding [x 1] (var-get #'x))

(let [x 1] (var-get #'x))

;; (binding [user/x 1] (var-get #'x))
;; (let [user/x 1] (var-get #'x))

;;let-introduced bindings are not mutable.  binding-introduced bindings are thread-locally mutable

(binding [x 1] (set! x 2) x)

;; (let [x 1] (set! x 2) x)
;; For binding, all the initial values are evaluated before any of them are bound to the vars. This is different from let, where you can use the value of a previous "alias" in a subsequent definition.

(def ^:dynamic y 0)

(let [x 1 y (+ x 1)] (list x y))

(binding [x 1 y (+ x 1)] (list x y))
