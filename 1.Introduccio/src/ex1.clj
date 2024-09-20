(ns ex1)

(def x 2)

(defn resultado "Cálculo de la función" []
  (+ 1 (/ (+ 1 (* 2 x)) 3) (* x x)))

(println (resultado))