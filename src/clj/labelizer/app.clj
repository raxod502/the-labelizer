(ns labelizer.app
  "Ring app to handle HTTP requests.")

(defn handler
  "Primary Ring handler for the server."
  [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Hello, world!"})
