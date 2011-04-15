(ns diffbot.core
  (:require [clj-http.client :as client])
  (:use clojure.contrib.pprint
	clojure.contrib.str-utils
	clojure.contrib.json))

(def *base-url* "http://www.diffbot.com/api/")

(defn api-action [method path & [opts]]
  (client/request
    (merge {:method method :url (str *base-url* path)} opts)))

(defn analyze [url token]
  (let [path (str "article?token=" token "&url=" url)]
    (read-json (:body (api-action :get path)))))

;;(client/request
;; (merge {:method method :url (str api-base path)} opts))
