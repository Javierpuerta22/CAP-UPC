(ns examen_prep_final)

(defn media [lista]
    (reduce (fn [accum x] (+ accum (/ x (count lista)))) 0 lista)
)

(defn aplanar [listas]
    (reduce (fn [accum list] (vec (concat accum list)) ) [] listas)
)

(defn contar_if [pred]
    (letfn [(aplicar [lista]
        (reduce (fn [accum x] (if (pred x) (inc accum) (+ accum 0))) 0 lista)
    )]
    aplicar
    )
)