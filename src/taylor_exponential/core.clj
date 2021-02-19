(ns taylor-exponential.core
  (:gen-class))

(defn- fact [n] (apply * (range 1 (inc n))))

(defn- e-taylor
  ([] (e-taylor 1))
  ([x] (lazy-seq (cons (/ x (fact x)) (e-taylor (inc x))))))

(defn e
  "Gives the sum of the nth first terms in the Taylor series expansion for the e number"
  [n]
  (double (apply + (take n (e-taylor)))))

