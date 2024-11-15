(ns ex1)

;; slow fib

(defn slow_fib [n]
    (cond
        (zero? n) 0
        (= n 1) 1
        :else (+ (slow_fib (dec n)) (slow_fib (dec (dec n))))    
    )
)


;; quick fib

(defn fib [n]
    (cond
        (< n 2) [0 n]
        :else (let [[f1 f2] (fib (dec n))]
                [f2 (+ f1 f2)]
        )
    )
)

(defn quick_fib [n]
     (second (fib n))
)

(defn iter_fib [n]
    (loop [accum_1 1 accum_2 1 i n]
        (cond
            (< i 2) accum_1
            :else (recur (+ accum_1 accum_2) accum_1 (dec i))
        )
    )
)

;; fib-cps
(defn fib_cps [n cont]
    (if (< n 2)
        (cont 1)
        (fib_cps (dec n) (fn [f1]
            (fib_cps (dec (dec n)) (fn [f2]
                (cont (+ f1 f2))
            ))
        ))
    )
)


;; cps2fib

(defn cps2fib [n cont]
    (if (< n 2)
        #(cont 1)
        #(cps2fib (dec n) (fn [f1]
            (fn [] (cps2fib (dec (dec n)) (fn [f2]
                (fn [] (cont (+ f1 f2)))
            )))
        ))
    )
)


;; ejemplos

(time (slow_fib 15))
(time (quick_fib 15))
(time (iter_fib 15))
(time (fib_cps 15 identity))
(time (trampoline cps2fib 15 identity))
