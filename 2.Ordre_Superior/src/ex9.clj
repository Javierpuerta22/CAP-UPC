(ns ex9)

(defn my-map-for [f lst] 
    (for [x lst] (f x))
)

(println (my-map-for #(* % 2) (range 1 5)))

(defn my-filter [f lst]
    (for [x lst :when (f x)] x)
)

(println (my-filter odd? (range 1 5)))

(defn my-zip-with [f lst1 lst2]
        (for [
            i (range 0 (min (count lst1) (count lst2))) 
            :when (< i (min (count lst1) (count lst2)))] 
            
            (f (nth lst1 i) (nth lst2 i))
        )
    
)

(println (my-zip-with * (range 1 4) (range 1 4)))

(defn thingify [lst1 lst2]
    (for [x lst1 y lst2 :when (== 0 (mod x y))] [x y])
)

(println (thingify (range 1 6) (range 1 3)))

(defn factors [n]
    (for [x (range 1 (inc n)) :when (== 0 (mod n x))] x)
)

(println (factors 24))