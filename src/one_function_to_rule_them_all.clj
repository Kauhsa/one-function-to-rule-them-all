(ns one-function-to-rule-them-all)

(defn concat-elements [a-seq]
  (reduce concat () a-seq))

(defn my-interpose [x a-seq]
  (if (empty? a-seq)
    []
    (reduce #(conj (conj %1 x) %2) [(first a-seq)] (rest a-seq))))

(defn str-cat [a-seq]
  (reduce str (my-interpose " " a-seq)))

(defn my-count [a-seq]
  (reduce (fn [x, _] (+ x 1)) 0 a-seq))

(defn my-reverse [a-seq]
  (reduce #(cons %2 %1) () a-seq))

(defn min-max-element [a-seq]
  (reduce #(vector (min (first %1) %2) (max (second %1) %2)) [(first a-seq) (first a-seq)] (rest a-seq)))

; tämähän räjähti käsiin kek
(defn insert [sorted-seq n]
  (loop [acc ()
         s sorted-seq
         i n]
    (cond
      (and (empty? s) (not (nil? i)))
        (cons i acc)
      (empty? s)
        acc
      (and (not (nil? i)) (< (last s) i))
        (recur (cons i acc) s nil)
      :else
        (recur (cons (last s) acc) (butlast s) i))))

(defn insertion-sort [a-seq]
  (reduce insert () a-seq))

(defn toggle [a-set elem]
  (if (contains? a-set elem) (disj a-set elem) (conj a-set elem)))

(defn parity [a-seq]
  (reduce toggle #{} a-seq))

(defn minus
  ([x] (- x))
  ([x y] (- x y)))

(defn count-params [& x]
  (count x))

(defn my-* 
  ([] 1)
  ([x] x)
  ([x y] (* x y))
  ([x y & z] (reduce my-* (* x y) z)))

(defn pred-and 
  ([] (fn [_] true))
  ([x] #(x %1))
  ([x y] #(and (x %1) (y %1)))
  ([x y & z] #(reduce (fn [a b] (and a (b %1))) ((pred-and x y) %1) z)))

(defn my-map [f a-seq]
  [:-])