(ns labelizer.env
  "Code and configuration for the development environment."
  (:require [ring.middleware.reload :as middleware-reload]))

(defn wrap-middleware
  "Wrap a Ring handler with development-only middleware."
  [handler]
  (-> handler
    (middleware-reload/wrap-reload)))
