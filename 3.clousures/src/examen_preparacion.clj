


(defn apply-if [pred transform]
    (letfn [(applythings [coll]
            (->> coll
                (map #(if (pred %) (transform %) %))
            )
        )]
    applythings
    )
)


(def func2 (apply-if even? #(* % %)))

(println (func2 [1 2 3 5 6]))
(println (func2 [1 3 7 8 88]))
(println (func2 [78 2 5 7 6]))


(defn filter-and-map [pred transform]
    (letfn [(aplicar [coll]
        (->> coll
            (filter pred)
            (map transform)
        )
    )]
    aplicar
    )
)

(def func22 (filter-and-map #(> % 5) #(* % 2)))

(println (func22 [1 2 3 5 6]))
(println (func22 [1 3 7 8 88]))
(println (func22 [78 2 5 7 6]))

(defn compose-multiple [fns]
    (letfn [(aplicar [valores]
            (reduce (fn [acc f]
                    (f acc))
                    valores fns)
        )]
    aplicar
    )
)

(def prueba3 (compose-multiple [(partial map inc) (partial filter #(> % 3))(partial filter even?)]))
(println (prueba3 [1 2 3 4 6]))


(defn group-by-predicate [pred]
    (letfn [(aplicar [valores]
        (->> valores
            (map #(if (pred %) [true %] [false %]))
            (reduce (fn [acc [key val]]
                (update acc key conj val)
            )  {true [] false []})
        )
    )]
    aplicar
    )
)

(def prueba4 (group-by-predicate even?))

(println (prueba4 [1 2 3 4 5 6 7]))
