(ns ex1)

(defn misteri [n]
  (let [secret 4
        n (+ n 2)]
    (fn [mult]
      (* secret (* mult n)))))
(defn misteri3 [param]
  (fn [bonus]
    (+ (param 6) bonus)))

(let [h (misteri 3)
      j (misteri3 h)
      result (j 2)]
  (println result))

  ;; result = (+ (*4 (* 6 5)) 2) = 122
  ; bonus = 2 degut a que es l'ultim paràmetre que es dona a la funció j
  ; param equival a (*4 (* 6 5)) que es el resultat d'aplicar la funció h a 6, on la funció h es defineix com a (*4 (* mult 5)) on mult = 6
  ; per tant, el resultat de la funció j es el resultat de sumar el resultat de la funció h a 6 amb el bonus que es 2

