(ns ex4)

(defn resultat "Nota textual" [n]
  (cond
    (and (>= n 9) (<= n 10)) "Excel·lent"
    (and (>= n 7) (<= n 8)) "Notable"
    (and (>= n 5) (<= n 6)) "Aprovat"
    :else "Suspès"
    )
  )

(println (resultat 9))
(println (resultat 8))
(println (resultat 6.5))
(println (resultat 4))
