(ns labelizer.server
  "Start and stop the webserver."
  (:gen-class)
  (:refer-clojure :exclude [defonce])
  (:require [environ.core :as environ]
            [labelizer.util :as util :refer [defonce]]
            [org.httpkit.server :as httpkit]))

(def port
  "Numerical port for server to listen on."
  (Long/parseLong (:port environ/env "3000")))

(defonce ^:dynamic stop-server-fn
  "Function used to stop the currently running server, or nil if none
  running."
  nil)

(defn start-server
  "Stop any existing server and start a new one."
  []
  (when stop-server-fn
    (stop-server-fn)
    (println "Server stopped."))
  (alter-var-root #'stop-server-fn (constantly (httpkit/run-server :port port)))
  (println (str "Server running on port " port ".")))

(defn stop-server
  "Stop any existing server."
  []
  (if stop-server-fn
    (do
      (stop-server-fn)
      (alter-var-root #'stop-server-fn (constantly nil))
      (println "Server stopped."))
    (println "No server currently running.")))

(defn -main
  "Main entry point. Ignores args and runs server."
  [& args]
  (start-server))
