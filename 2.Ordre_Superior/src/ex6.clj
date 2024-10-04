(ns ex6)

( def ex6 (comp (partial reduce +) (partial filter odd?) (partial map #(count %))) )


(println (ex6 ["hola" "adeu" "bon dia" "bona nit" "fins aviat" "fins demà"]))