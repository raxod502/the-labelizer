(ns ^:figwheel-no-load labelizer.init
  "Loading this namespace initializes the webapp."
  (:require [labelizer.core :as core]))

(core/render)
