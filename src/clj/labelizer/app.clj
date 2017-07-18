(ns labelizer.app
  "Ring app to handle HTTP requests."
  (:require [bidi.bidi :as bidi]))

(defn response
  "Construct a Ring response."
  [status body]
  {:status status
   :headers {"Content-Type" "text/html"}
   :body body})

(defn handler
  "Primary Ring handler for the server."
  [{:keys [uri] :as request}]
  (if (= uri "/")
    (response 200 "You have reached the webserver!")
    (response 404 "Page not found.")))
