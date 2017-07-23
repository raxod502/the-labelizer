(ns labelizer.core
  "The main code for the webapp."
  (:require [labelizer.util :as util]
            [reagent.core :as reagent]))

(defn app
  "The main app."
  []
  [:div
   "This is the webapp!"])

(defn render
  "Render the main app."
  []
  (reagent/render app (util/get-element-by-id "app")))
