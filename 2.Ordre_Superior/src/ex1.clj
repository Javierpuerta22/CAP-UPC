(ns ex1)


(defn sumatots [n]
  ((comp (partial reduce +) (partial map #(* 2 %)) (partial filter even?)) n)
)

(println (sumatots [1 2 3 4]))