(ns exteoria)


(defn generador_cues []
    (let [ed (let [davant (atom '())
            darrere (atom '())]
        {
            :reset #(do (reset! davant '()) (reset! darrere '()))

            :push #(do (swap! darrere (partial cons %)) nil)

            :top #(when (or (not (empty @davant))
                            (not (empty @darrere)))
                        (do (when (empty? @davant)
                            (do (reset! davant (reverse @darrere))
                                (reset! darrere '())))
                                (first @davant)))

            :pop #(when (or (not (empty? @davant))
                            (not (empty? @darrere)))
                        (do (when (empty? @davant)
                            (do (reset! davant (reverse @darrere))
                                (reset! darrere '())))
                                (let [ret (first @davant)]
                                    (swap! davant rest)
                                    ret
                                )))
            :empty #(and (empty? @davant)
                             (empty? @darrere))

            :content #(concat @davant (reverse @darrere))
            
            :equal #(let [continguts (% :content)]
                        (= continguts
                            (concat @davant (reverse @darrere))))
                

        })]
    
    (fn [& cmd]
        (let [instr (keyword (first cmd))
            argum (rest cmd)
            f (instr ed)]
            (apply f argum)
        )
    )
    )
)