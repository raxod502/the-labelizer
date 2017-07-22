(ns labelizer.env
  "Code and configuration for the production environment.")

(def wrap-middleware
  "Wrap a Ring handler with production-only middleware."
  identity)
