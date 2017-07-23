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

  :main labelizer.server
  :min-lein-version "2.6.1"
  :source-paths ["src/clj"]
  :uberjar-name "the-labelizer.jar"

  :figwheel {:destroy labelizer.server/stop-server
             :init labelizer.server/start-server}

  :profiles {:dev {:plugins [[lein-figwheel "0.5.10"]]

                   :resource-paths ["target/resources/dev"]
                   :source-paths ["env/dev/clj"]

                   :cljsbuild
                   {:builds
                    {:app
                     {:compiler
                      {:asset-path "js/lib"
                       :main labelizer.core
                       :output-dir "target/resources/dev/public/js/lib"
                       :output-to "target/resources/dev/public/js/main.js"}
                      :figwheel true
                      :source-paths ["src/cljs"]}}}}

             :uberjar {:cljsbuild
                       {:builds
                        {:app
                         {:compiler
                          {:main labelizer.core
                           :optimizations :advanced
                           :output-dir "target/cljsbuild/uberjar"
                           :output-to "target/resources/uberjar/public/js/main.js"
                           :pretty-print true}
                          :source-paths ["src/cljs"]}}}

                       :aot :all
                       :main labelizer.server
                       :omit-source true
                       :prep-tasks ["compile" ["cljsbuild" "once"]]
                       :resource-paths ["target/resources/uberjar"]
                       :source-paths ["env/prod/clj"]}})
