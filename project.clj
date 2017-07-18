(defproject raxod502/the-labelizer "0.1.0-SNAPSHOT"
  :description "Add some jazz to your GitHub issue labels."
  :license {:name "MIT License"
            :url "http://www.opensource.org/licenses/mit-license.php"}
  :url "https://github.com/raxod502/the-labelizer"

  :dependencies [[environ "1.1.0"]
                 [http-kit "2.2.0"]
                 [org.clojure/clojure "1.8.0"]
                 [ring "1.6.2"]]

  :main labelizer.server
  :min-lein-version "2.7.1"
  :source-paths ["src/clj"]
  :uberjar-name "the-labelizer.jar"

  :profiles {:uberjar {:aot :all}})
