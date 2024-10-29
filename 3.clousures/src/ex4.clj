(ns ex4)

(defn memoize2 [f]
    (let [mem (atom {})]
        (fn [& args]
            (if-let [e (find @mem args)]
                (val e)
                (let [ret (apply f args)]
                    (swap! mem assoc args ret)
                    (println "Calculating" args)
                    (println "Current state" @mem)
                    (println "Result" ret)
                    (println "----------------")
                    ret
                )
            )
        )
    )
)

(defn fib [n]
  (if (<= n 1)
    n
    (+ (fib (dec n)) (fib (- n 2)))))

(time (fib 35))


(def fib (memoize2 fib))

(time (fib 35))
