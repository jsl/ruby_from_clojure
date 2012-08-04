(ns speaker-selector.core
  (import [com.steelcity Schedule]))

(defn top-speaker
  "Returns the top speaker for the given day"
  [day]
  (first (shuffle (.speakers (new Schedule day)))))
