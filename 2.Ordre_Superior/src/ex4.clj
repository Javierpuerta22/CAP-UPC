(ns ex4)


(defn suma-total [lst]

((comp (partial reduce +) (partial filter #(> % 100)) (partial map #(* (:preu %) (:quantitat %)))) lst)
)



  (println (suma-total [{:nom "poma" :preu 10 :quantitat 100} {:nom "pera" :preu 20 :quantitat 50} {:nom "kiwi" :preu 3 :quantitat 30} {:nom "taronges" :preu 4 :quantitat 20} {:nom "maduixes" :preu 5 :quantitat 10}]))
