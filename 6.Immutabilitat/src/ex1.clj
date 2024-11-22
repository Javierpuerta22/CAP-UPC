(ns ex1)

(def t1 {
    :v 1
    :R {:v 3 :L {:v 6 :L nil :R nil} :R {:v 7 :L nil :R nil}}
    :L {:v 2 :L {:v 4 :L nil :R nil} :R {:v 5 :L nil :R nil}}
})

(def t2 {:v 2 :L {:v 4 :L nil :R nil} :R {:v 5 :L nil :R nil}})

(def t3 {:v 3 :L {:v 6 :L nil :R nil} :R {:v 7 :L nil :R nil}})

(defn size [t]
    (cond
        (and (nil? (:R t)) (nil? (:L t))) 1
        (nil? (:L t)) (+ 1 (size (:R t)))
        (nil? (:R t)) (+ 1 (size (:L t)))
        :else (+ 1 (size (:R t)) (size (:L t)))
    )
)

(defn height [t]
    (cond
        (and (nil? (:R t)) (nil? (:L t))) 1
        :else (+ 1 (max (height (:R t)) (height (:L t))))
    )
)

(defn equal [t1 t2]
    (cond 
    (and (nil? (:v t1)) (nil? (:v t2))) true
    :else (and (= (:v t1) (:v t2)) (equal (:R t1) (:R t2)) (equal (:L t1) (:L t2)))
    )
)

(defn pre-order [t]
    ;; raiz izquierdo derecho
    (cond
        (nil? t) []
        :else (concat [(:v t)] (pre-order (:L t)) (pre-order (:R t)))
    )
)

(defn in-order [t]
    ;; izquierdo raiz derecho
    (cond
        (nil? t) []
        :else (concat  (pre-order (:L t)) [(:v t)] (pre-order (:R t)))
    )

)

(defn post-order [t]
    ;;  izquierdo derecho raiz
    (cond
        (nil? t) []
        :else (concat (pre-order (:L t)) (pre-order (:R t)) [(:v t)])
    )
)

(defn bfs 
    ([t] (bfs [t] []))
    ([q r]
        (println q)
        (println (first q))
        (println r)
        (println "-------------")
        (if (empty? q) r
        (let [a (first q)]
            (cond 
                (nil? (:v a)) []
                ;(nil? (:R a)) (recur (conj (rest q) (:L a)) (conj r (:v a)) )
                ;(nil? (:L a)) (recur (conj (rest q) (:R a)) (conj r (:v a)))
                :else (recur (conj (rest q) (:L a) (:R a)) (conj r (:v a)))
            )
        ))
    )
)