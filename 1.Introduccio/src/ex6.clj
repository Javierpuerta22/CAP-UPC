(ns ex6)

(defn my-count1 
  "Calcula la len de lst recursivament"
  [lst]
  (let [count 0]
    (if (empty? lst) 
      count
      (inc (my-count1 (rest lst))))
    )
  )

(defn my-count2
  "Calcula la len de lst amb bucles"
  [lst]
  (loop [count 0
         aux lst]
    (if (empty? lst)
      count
      (recur (inc count) (rest aux)))
    )
  )

(defn my-maximum1 "Càlcul màxim recursiu" [l]
  (def x1 (first l)) 
  (def x2 (first (rest l)))

  (if (= (my-count1 l) 1)
    (first l) 
    (if (> x1 x2)
      (my-maximum1 (cons x1 (rest (rest l)))
      )
      (my-maximum1 (cons x2 (rest (rest l)))
      ) 
    ) 
))

(defn my-maximum2
  "Calcula el max de lst amb bucles.
   S'ha de cridar amb quote. Ex:
       (my-maximum2 '(1 2 5 4 8 2))
   "
  [lst]
  (loop [aux (rest lst)
         n (first lst)]
    (if (empty? aux)
      n
      (recur (rest aux) 
             (if (> (first aux) n)
               (first aux)
               n)
    )))
  )

(defn average1 "Càlcul mitjana recursiu" [l]
  (if (empty? l)
      0
      (/ (reduce + l) (count l))))

(defn average2
  "Calcula la mean de lst amb bucles"
  [lst]
  (try
    (if (empty? lst)
      (throw (Exception. "The list cannot be empty."))
      (loop [count 0
             sum 0
             aux lst]
        (if (empty? aux)
          (/ sum count)
          (recur (inc count) (+ sum (first aux)) (rest aux)))))
    (catch Exception e
      (.getMessage e))))