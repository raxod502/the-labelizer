(defproject raxod502/the-labelizer "0.1.0-SNAPSHOT"
  :description "Add some jazz to your GitHub issue labels."
  :license {:name "MIT License"
            :url "http://www.opensource.org/licenses/mit-license.php"}
  :url "https://github.com/raxod502/the-labelizer"

  :dependencies [[environ "1.1.0"]
                 [hiccup "1.0.5"]
                 [http-kit "2.2.0"]
                 [org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.671"]
                 [ring "1.6.2"]]

  :plugins [[lein-cljsbuild "1.1.6"]]

  :clean-targets ^{:protect false} [[:cljsbuild :builds 0 :compiler :output-dir]
                                    [:cljsbuild :builds 0 :compiler :output-to]
                                    :target-path]
  :main labelizer.server
  :min-lein-version "2.7.1"
  :source-paths ["src/clj"]
  :uberjar-name "the-labelizer.jar"

  :cljsbuild {:builds [{:source-paths ["src/cljs"]
                        :compiler {:asset-path "js/lib"
                                   :main labelizer.core
                                   :output-dir "resources/public/js/lib"
                                   :output-to "resources/public/js/main.js"}}]}

  :profiles {:uberjar {:aot :all}})
