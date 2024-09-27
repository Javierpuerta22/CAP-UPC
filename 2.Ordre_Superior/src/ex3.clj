(ns ex3)



(defn ex3 [n]
((comp (partial map #(* 10 %)) (partial take 3) (partial filter #(>= % 0))) n))


(println (ex3 [-1 2 -3 4 -5 6 -7 8 -9 10]))