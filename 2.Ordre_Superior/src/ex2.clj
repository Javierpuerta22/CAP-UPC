(ns ex2)

;; dado un dict de nombres y edades, devolver una lista ordenada alfabeticamente de los mayores de 18



(defn mayores-edad [n]
    ((comp (partial sort) (partial keys) (partial filter #(> (val %) 18))) n)
)

(println (mayores-edad {:r 12 :g 19 :c 20 :a 15 :e 25 :f 30}))