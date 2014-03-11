(ns clj.where)

(defn where
  "where for arrays of maps.
   For example, you have a vector of key-value maps,such as:

    (def cats
       [
         {
          :name  \"Bubbles\"
          :favoriteFood \"mice\"
          :age 1
         },
         {
          :name \"Sparkle\"
          :favoriteFood \"tuna\"
         },
         {
          :name \"flyingCat\"
          :favoriteFood \"mice\"
          :age 1
         }
      ])

You want to filter with some properties,like:

    user=> (where cats {:age 1})
    ({:age 1, :name \"Bubbles\", :favoriteFood \"mice\"} {:age 1, :name \"flyingCat\", :favoriteFood \"mice\"})

    user=> (where cats {:age 1 :name \"Bubbles\"})
     ({:age 1, :name \"Bubbles\", :favoriteFood \"mice\"})

    user=> (where cats {:age 1, :favoriteFood \"tuna\"})
    ()
  "
  ([xs query]
     (where xs query =))
  ([xs query matcher]
     (let [hit (apply hash-set (keys query))
           expects (count hit)]
       (filter (fn [x]
                 (= expects
                    (reduce (fn [matches [k v]]
                              (if (and (hit k) (matcher (get query k) v))
                                (inc matches)
                                matches)) 0 x))) xs))))
