(ns labelizer.util
  (:refer-clojure :exclude [defonce]))

(defmacro defonce
  "Replacement for `clojure.core/defonce` that takes docstring."
  {:arglists '([symbol] [symbol init] [symbol doc-string init])}
  [name & args]
  `(let [v# (def ~name)]
     (when-not (.hasRoot v#)
       (def ~name ~@args))))
