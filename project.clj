(defproject clj-http "4.0.0-SNAPSHOT"
  :description "A Clojure HTTP library wrapping the Apache HttpComponents client."
  :url "https://github.com/dakrone/clj-http/"
  :license {:name "The MIT License"
            :url "http://opensource.org/licenses/mit-license.php"
            :distribution :repo}
  :global-vars {*warn-on-reflection* false}
  :min-lein-version "2.0.0"
  :exclusions [org.clojure/clojure]
  :dependencies [
                 ;; [org.apache.httpcomponents/httpcore "4.4.9"]
                 [org.apache.httpcomponents.core5/httpcore5 "5.0-beta2"]
                 ;; [org.apache.httpcomponents/httpclient "4.5.5"]
                 [org.apache.httpcomponents.client5/httpclient5 "5.0-beta1"]
                 ;; [org.apache.httpcomponents/httpasyncclient "4.1.3"]
1                 [org.apache.httpcomponents/httpmime "4.5.5" :exclusions
                  [org.apache.httpcomponents/httpclient]]
                 [commons-codec "1.11"]
                 [commons-io "2.6"]
                 [potemkin "0.4.4"]]
  :profiles {:dev {:dependencies [;; optional deps
                                  [cheshire "5.8.0"]
                                  [crouton "0.1.2"]
                                  [org.clojure/tools.reader "1.2.1"]
                                  [com.cognitect/transit-clj "0.8.300"]
                                  [ring/ring-codec "1.1.0"]
                                  ;; other (testing) deps
                                  [org.clojure/clojure "1.9.0"]
                                  [org.clojure/tools.logging "0.4.0"]
                                  [log4j "1.2.17"]
                                  [ring/ring-jetty-adapter "1.6.3"]
                                  [ring/ring-devel "1.6.3"]
                                  ;; caching example deps
                                  [org.clojure/core.cache "0.6.5"]]
                   :plugins [[lein-ancient "0.6.15"]]}
             :1.6 {:dependencies [[org.clojure/clojure "1.6.0"]]}
             :1.7 {:dependencies [[org.clojure/clojure "1.7.0"]]}
             :1.8 {:dependencies [[org.clojure/clojure "1.8.0"]]}}
  :aliases {"all" ["with-profile" "dev,1.6:dev,1.7:dev,1.8:dev"]}
  :plugins [[codox "0.6.4"]]
  :test-selectors {:default  #(not (:integration %))
                   :integration :integration
                   :all (constantly true)})
