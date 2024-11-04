(ns examen_preparacion3)


(defn sumador []
    (let [ed 
        (let [contador (atom 0)]
            {
                :get (fn [] @contador)
                :add (fn [x] (swap! contador + x))
            }
        )] 
    
    (fn [& args]
        (let [
            comando (keyword (first args))
            args_total (rest args)
            f (get ed comando)
        ]   
            (apply f args_total)
        )
    
    ))
)

(defn banco []
    (let [balance (atom 0)]
        (letfn [(depositar [cantidad]
            (swap! balance + cantidad)
            @balance)

            (retirar [cantidad]
                (cond 
                    (> (- @balance cantidad) 0) (do (swap! balance - cantidad) @balance)
                    :else (throw (Exception. "Fondos insuficientes"))
                )
            )]
    
    [depositar retirar])
    )
)

(defn calculadora []
        (letfn [(calcular [f x y]
            (f x y)
        )]
        calcular
        )
)


(defn iterador [x]
    (let [ed 
        (let [pos (atom -1)
                iter (atom x)]
            {
                :next (fn [] (cond
                                (> @pos (- (count @iter) 1)) (throw (Exception. "Iteration error"))
                                :else (do (swap! pos inc) (nth @iter @pos))
                                ))
                :reset (fn [] (do (reset! pos -1) (println "iterador reseteado al principio")))
                :reset_iter (fn [new_iter] (do (reset! pos -1) (reset! iter new_iter)))
            }
    )]
    (fn [& args]
         (let [
            com (keyword (first args))
            args_total (rest args)
            f (get ed com)
        ]
        (apply f args_total)
        
        )
    )
    )

)


(defn decision_tree [pairs]
    (letfn [(decision_making [valor]
        (reduce (fn [val [pred f]]
            (if (pred val)
                (f val)
                val))
            valor pairs))]
        decision_making
    )
)

;; Definir algunos predicados y closures para el ejemplo
(defn es-par? [n] (zero? (mod n 2)))
(defn es-multiplo-de-3? [n] (zero? (mod n 3)))
(defn es-negativo? [n] (< n 0))

(defn sumar-10 [n] (+ n 10))
(defn multiplicar-por-2 [n] (* n 2))
(defn absoluto [n] (Math/abs n))

;; Crear el árbol de decisiones
(def arbol-decision (decision_tree [[es-par? sumar-10]
                                           [es-multiplo-de-3? multiplicar-por-2]
                                           [es-negativo? absoluto]]))

;; Evaluar el árbol de decisiones con un valor de entrada
(println (arbol-decision -6))



(defn histograma3 [imagen]
    (reduce (fn [accum x]
        (let [val (get accum x)]
            (if val
                (assoc accum x (inc val))
                (assoc accum x 1)
            )
        )
    ) (sorted-map) imagen)
)