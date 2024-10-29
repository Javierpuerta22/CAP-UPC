(ns ex5)

(defn Punt []
    (let [
        x (atom 0)  
        y (atom 0) 
        dicc {
                :x @x
                :y @y
                :incx (do (swap! x inc) [@x @y])
                :incy (do (swap! y inc) [@x @y])
                :crt [@x @y]
            }
        ]
        (fn 
            ([f]
                (f dicc)
            )
       )
    )
)









(defn Punt2 []

    (let [x (atom 0) y (atom 0)] 
        (fn 
            ([f]
                (f {:x @x 
                    :y @y
                    :incx (do (swap! x inc) (seq [@x @y]))
                    :incy (do (swap! y inc) (seq [@x @y]))
                    :crt (seq [@x @y])
                    :plr (seq [(#(Math/sqrt (+ (* @x @x) (* @y @y))) (#(/ (* (Math/atan2 @x @y) 180) Math/PI)))] )})
                )
            ([f p1]
            (f {
                :dst (Math/sqrt (+ (* (- (p1 :x) @x) (- (p1 :x) @x)) (* (- (p1 :y) @y) (- (p1 :y) @y))))
            })
            )
        )
    )


    ;; 
    ;;     ([] (let ))
        
    ;;     ([f]
    ;;     (let [  x (atom x) 
    ;;             y (atom y)])
        ;; (f {:x @x 
        ;;     :y @y
        ;;     :incx (do (swap! x inc) (seq [@x @y]))
        ;;     :incy (do (swap! y inc) (seq [@x @y]))
        ;;     :crt (seq [@x @y])
        ;;     :plr (seq [(#(Math/sqrt (+ (* @x @x) (* @y @y)))) (#(/ (* (Math/atan2 @x @y) 180) Math/PI))] )})
        ;; )

        ;; ([f p1]
        ;; (f {
        ;;     :dst (Math/sqrt (+ (* (- (p1 :x) @x) (- (p1 :x) @x)) (* (- (p1 :y) @y) (- (p1 :y) @y))))
        ;; })
       ;; )
        
    ;;)
)