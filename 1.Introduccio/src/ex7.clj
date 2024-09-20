(ns ex7)

(defn build-palindrome "Construir palindrome amb la llista invertida a la donada" [l] 
  (let [reversed (reverse l)]
    (concat reversed l)
    )
  )


(defn remove-list 
  "Donada la llista x i y, retorna x havent eliminat totes les ocurrències
   dels elements en y."
  [x y]
  (loop [result '()
         remaining x]
    (if (empty? remaining)
      (reverse result)
      (let [current (first remaining)]
        (if (some #(= current %) y) ; Important, nou mètode
          (recur result (rest remaining))
          (recur (conj result current) (rest remaining)))
        ))
    )
  )
;; TODO: Mantener el orden en la lista -> (reverse result)

(defn remove-list-2
   "Manera proporcionada pel chat que manté l'ordre.
   Què és més eficient?" 
  [x y]
  (remove (set y) x))

  
(defn odds-n-evens "Retorna dues llistes, una amb els parells i l'altra amb els senars" [l]
   (loop [parells '()
          senars '()
          aux l]
     
     (if (empty? aux)
       (list (reverse senars) (reverse parells))
       
       (if (even? (first aux))
         (recur (cons (first aux) parells) senars (rest aux))
         (recur parells (cons (first aux) senars) (rest aux))
         )
       )
  ))


(defn prime-divisors 
  "Retorna la llista de divisors primers d'un enter estrictament positiu.
   Mode: Recursiu"
  ([n] (prime-divisors n '() 1))
  ([n lst m]
   (cond
     (> m n) (reverse lst) ;Puc usar-ho?
     (zero? (mod n m)) (prime-divisors n (conj lst m) (inc m))
     :else (prime-divisors n lst (inc m))
     )
   ) 
  )