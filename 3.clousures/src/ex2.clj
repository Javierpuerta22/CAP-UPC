(ns ex2)

(defn Punt [x y]
    (fn 
        ([f]
        (f {:x x 
            :y y
            :crt (seq [x y])
            :plr (seq [(#(Math/sqrt (+ (* x x) (* y y)))) (#(/ (* (Math/atan2 x y) 180) Math/PI))] )})
        )
        ([f p1]
        (f {
            :dst (Math/sqrt (+ (* (- (p1 :x) x) (- (p1 :x) x)) (* (- (p1 :y) y) (- (p1 :y) y))))
        })
        )
    )
)

(println ((Punt 2 2) :plr))

(println ((Punt 2 2) :dst (Punt 2 0)))


(defn mes-propera [p lista]
    (->> (map #(hash-map :point (seq [(% :x) (% :y)]) :dst (p :dst %)) lista)
      (reduce min-key :dst)
      :point
    )
)

(println (mes-propera (Punt 2 2) [(Punt 2 0) (Punt 0 2) (Punt 0 0)]))