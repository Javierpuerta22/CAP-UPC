(ns ex8)
(require '[clojure.string :as str])

(defn post-fixa-primer
  "Avalua una expressió escrita en notació 
   postfixa amb només nombres naturals i 
   operadors de suma, resta, producte i divisió"

  [s]
  
  (let [tokens (str/split s #" ")
        operators #{"+" "-" "*" "/"}] 
    
    (loop [t (first tokens)
           pila []
           toks (rest tokens)]
      
      (if (nil? t)
        (peek pila)
        
        (if (operators t)
          
          (let [op (symbol t)
                b (peek pila)
                a (peek (pop pila))
                result (eval (list op a b))]
            
            (recur (first toks) 
                   (conj (pop (pop pila)) result) 
                   (rest toks))
            )
          
          (recur (first toks) 
                 (conj pila (Integer/parseInt t)) 
                 (rest toks)))) 
      ) 
    ))

(defn post-fixa-segon
  "Avalua una expressió escrita en notació 
   postfixa amb només nombres naturals i 
   operadors de suma, resta, producte i divisió"

  [s]

  (let [tokens (str/split s #" ")
        operators #{"+" "-" "*" "/"}]

    (loop [t (first tokens)
           pila []
           toks (rest tokens)]

      (if (nil? t)
        (if (> (count pila) 1)
          (throw (Exception. "Op?!"))
          (peek pila))

        (if (operators t)
          (let [op (symbol t)
                b (peek pila)
                a (peek (pop pila))]

            (cond
              (and (= (str op) "/") (zero? b))          (throw (Exception. "div0"))
              (and (= (str op) "/") (not= (mod a b) 0)) (throw (Exception. "divE"))
              (nil? a)                                  (throw (Exception. "2ops"))
              (or (not (number? a)) (not (number? b)))  (throw (Exception. "NaN"))
              (< (eval (list op a b)) 0)                (throw (Exception. "neg"))
              :else (recur (first toks)
                           (conj (pop (pop pila)) (eval (list op a b)))
                           (rest toks))))

          (recur (first toks)
                 (conj pila (Integer/parseInt t))
                 (rest toks))
          )
        )
      
      ))
      )
