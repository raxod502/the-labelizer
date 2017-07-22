(ns labelizer.app
  "Ring app to handle HTTP requests."
  (:require [hiccup.core :as hiccup-render]
            [hiccup.page :as hiccup]
            [ring.middleware.content-type :as middleware-content-type]
            [ring.middleware.not-modified :as middleware-not-modified]
            [ring.middleware.resource :as middleware-resource]))

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
  "Hiccup code for the main webapp page."
  [:div
   "This is the webapp."
   (hiccup/include-js "/js/main.js")])

(def not-found
  "Hiccup code for the not-found page."
  "This page does not exist.")

(defn router
  "Ring handler for rendering pages."
  [{:keys [uri] :as request}]
  (if (= uri "/")
    (response 200 (page webapp))
    (response 404 (page not-found))))

(def handler
  "Main Ring handler for the server."
  (-> router
    (middleware-resource/wrap-resource "public")
    (middleware-content-type/wrap-content-type)
    (middleware-not-modified/wrap-not-modified)))
