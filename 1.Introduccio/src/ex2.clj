(ns ex2)

(def resultat "Valor entre varios rangos"
  (let [n 25]
    (cond
      (and (>= n 10) (<= n 20)) "petit"
      (and (>= n 30) (<= n 40)) "mitja"
      :else "gran")))

(println resultat)