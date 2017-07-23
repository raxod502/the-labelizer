(ns labelizer.util
  "Utility functions.")

(defn get-element-by-id
  "Return the DOM element with the given ID, or nil."
  [id]
  (.getElementById js/document id))
