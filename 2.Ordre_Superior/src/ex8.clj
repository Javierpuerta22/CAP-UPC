(ns ex8)

(defn eql [l1 l2]
    (and 
        (= (count l1) (count l2))
        ((comp
            (partial every? true?)
            (partial map #(= %1 %2))) l1 l2)
    )
)

(def prod-of-evens
    (comp 
        (partial reduce *)
        (partial filter even?))
    
)

(defn foldr
  [f val coll]
  (if (empty? coll) val
      (f (first coll) (foldr f val (rest coll)))))

(def my-reverse 
    (comp
        (partial foldr #(concat %2 [%1]) '())
    )
)

(def scalar-product
    (comp 
        (partial reduce +)
        (partial map #(* %1 %2))
    )
)

(defn count-in [lst x]
    ((comp
        (partial map count)
        (partial map (partial filter #(== x %)))) lst)
)


(def first-word
    (comp
        (partial apply str)
        (partial take-while #(not= \space %))
        (partial drop-while #(= \space %)) 
    )
  
)

(println (first-word "       hola que tal"))