(ns ex1)

(defn aplana [s]
    (if (empty? s) '()
        (let [
            [cap & cua] s
            recua (aplana cua)]
            (if (not (sequencial? cap)) (cons cap rescua)
                (let [rescap (aplana cap)]
                    (concat rescap rescua)
                ) 
            )
        )
    )  
)

(defn aplana-cps [s cont]
    (if (empty? s) (cont '())
        (let [
            [cap & cua] s]
            (if (not (sequencial? cap)) (aplana-cps cua (fn [v] (cont (cons cap v))))
                (aplana-cps cua (fn [v] (aplana-cps cap (fn [w] (cont (concat w v))))))
            )
        )
    )  
)

(defn aplana-t [ss]
    (letfn [(aplana-cps-t [s cont]
                (if (empty? s) #(cont '())
                    (let [
                        [cap & cua] s]
                        (if (not (sequencial? cap)) #(aplana-t cua (fn [v] (fn [] (cont (cons cap v)))))
                            #(aplana-t cua (fn [v] (fn [] (aplana-t cap (fn [w] (fn [] (cont (concat w v))))))))
                        )
                    )
                )  
            )]

    (trampoline aplana-cps-t ss identity)

    )
)
