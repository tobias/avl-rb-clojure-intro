;; hello world
(println "Hello world!")

;; function definition
(defn ham-is-good [a b]
  (println (if (or (= a "ham")
                   (= b "ham"))
             "Ham goes good with anything!"
             (str a " and " b "? Grody!"))))

(ham-is-good "ham" "biscuit")

;; java interop
(println Math/PI)

(doto (java.util.HashMap.)
  (.put "a" "b")
  (.toString))

;; laziness
(take 10 (range))

;; immutability
(def x {:a :b})
(assoc x :a "boom")
x




