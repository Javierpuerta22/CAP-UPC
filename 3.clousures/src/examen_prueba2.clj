(ns examen_prueba2)



(defn foldl [f x0 s]                 
  (if (empty? s) x0                   
      (let [[cap & cua] s]                
        (recur f (f x0 cap) cua))))          

(defn foldr [f x0 s]
    (if (empty? s) x0
         (let [[cap & cua] s]
         (f cap (foldr f x0 cua)))))


(def fold foldr)
;; scanl / scanr
(defn scanl [f x0 s]                  ;; (def scanl reductions)
  (if (empty? s) (list x0)
      (let [[cap & cua] s]
        (cons x0 (scanl f (f x0 cap) cua)))))

(defn scanr [f e lst]
  (letfn [(flip [ff] (fn [x y] (ff y x)))]
    (let [rlst   (reverse lst)]
      (reverse (scanl (flip f) e rlst)))))



;; probar fold i reduce

(defn invertir_lista [lista]
    (scanr (fn [acc x] (concat x [acc])) [] lista)
)

;;(println (invertir_lista [1 2 3 4 5 6 7]))

(defn diferencia-acumulada [coll]
    (reductions - 0 coll)
)

;;(println (diferencia-acumulada [1 2 3 4 5 6 7]))

(defn prefijos [coll]
    (reductions conj [] coll )
)

(println (prefijos [1 2 3 4 5 6 7]))

(defn sufijos [coll]
    (scanr #(vec (concat [%1] %2)) [] coll )
)

(println (sufijos [1 2 3 4 5 6 7]))

(defn histograma [coll]
    (reduce (fn [acc x]
        (if (get acc x)
            (assoc acc x (inc (get acc x)))
            (assoc acc x 0))
    ) {} coll)
)

(println (histograma [1 2 8 2 2 2 1 1 4 5 6 3  4 7 2 4 6]))
