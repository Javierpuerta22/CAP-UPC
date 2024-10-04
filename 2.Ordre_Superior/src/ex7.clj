(ns ex7)

(def ex7 (comp (partial map #(* % %)) (partial take 5) (partial filter #(not= 0 (mod % 3)))))



(println (ex7 (range 1 5)))