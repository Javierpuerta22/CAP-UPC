(ns ex3)

(defn my-partial [f & arg]
  (fn [& args]
    (apply f (concat arg args))
  ) 
)

(println ((my-partial * 2) 3))