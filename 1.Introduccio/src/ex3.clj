(ns ex3)

(defn resultat "Es par o senar?" [x]
  (if (odd? x)
    "senar"
    "parell"))

(println (resultat 2))
(println (resultat 3))