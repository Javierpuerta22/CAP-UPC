(ns ex5)


(defn valor-absolut "Retorna el valor absolut d'un valor" [x]
    (if (< x 0)
        (- x)
        x))

(defn power1 [x p]
    (if (= p 0)
        1
        (* x (power1 x (dec p)))))

(defn power2 [x p]
  (loop [i p
         accum x] 
    (cond (= i 1) accum
          (= i 0) 1 
          :else (recur (dec i) (* accum x)))))


(defn primer "Es un numero primer" [n] 
  (loop [i (int (Math/sqrt n))]
    (cond 
      (= i 1) true
      (zero? (mod n i)) false
      :else (recur (dec i)))))