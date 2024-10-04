(ns ex5)


(defn ex5 [lst]
((comp (partial (comp reverse sort)) (partial map #(* % 3)) (partial filter #(< 5 %))) lst)
)


(println (ex5 [1 2 3 4 5 6 7 8 9 10]))