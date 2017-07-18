(ns labelizer.app
  "Ring app to handle HTTP requests."
  (:require [hiccup.core :as hiccup-render]
            [hiccup.page :as hiccup]))

(defn response
  "Construct a Ring response."
  [status body]
  {:status status
   :headers {"Content-Type" "text/html"}
   :body body})

(defn page
  "Generate HTML from the Hiccup code for a page's body."
  [body]
  (hiccup-render/html
    (hiccup/html5
      [:head
       [:meta {:charset "utf-8"}]]
      [:body body])))

(def webapp
  "This is the webapp.")

(def not-found
  "This page does not exist.")

(defn handler
  "Primary Ring handler for the server."
  [{:keys [uri] :as request}]
  (if (= uri "/")
    (response 200 (page webapp))
    (response 404 (page not-found))))
