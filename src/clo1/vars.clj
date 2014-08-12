;; Vars ensure safe use of mutable storage locations via thread isolation

(def x)

x

(def x 1)

x

(def x 2)

x

(def ^:dynamic y 1)

(def ^:dynamic z 2)

(+ y z)

(binding [y 3 z 4] (+ y z))

(+ y z)

