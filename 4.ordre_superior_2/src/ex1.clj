(ns ex1)
(require '[clojure.string :as str])

(defn freqs [imagen]
    (reduce (fn [accum x]
        (let [val (get accum x)]
            (if val
                (assoc accum x (inc val))
                (assoc accum x 1)
            )
        )
    ) (sorted-map) imagen)
)


(defn paraules-inici-fi [text inici fi]
  (let [splitted (str/split text #" ")]
    (println splitted)
    (->> splitted
      (filter #(and (= (first %) inici) (= (last %) fi))) 
    )
  )
)


(defn ordre-diferents [ordre]
    (->> (str/split ordre #" ")
         freqs
         ;;(filter #(= (val %) 1))
         keys)
)

(defn ordre-mida [ciutats]
    (->> ciutats
        (filter #(> (count %) 5))
        (sort-by count)
    )
)

(defn agrupa [ciutats]
    (->> ciutats
        (reduce (fn [accum x]
                    (let [lista (first accum)
                          len (count lista)]
                        (if (= len 3)
                            (conj accum (list x))
                            (conj (pop accum) (conj lista x))
                        )
                    )
        ) '(()) )
    )
)

;; (defn agrupa [ciutats]
;;     (partition 3 3 nil ciutats)
;; )

(defn cartesia [x y z]
    (for [i x j y k z] (list [i j k]))
)

(require 'clojure.set)

(defn inner-join [l1 l2 clave]
    (for [x l1 y l2 :when #(= (:regId x) (:regId y))] (clojure.set/union x y))
)