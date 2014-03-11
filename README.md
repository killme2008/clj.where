# clj.where

A Clojure library designed to query maps in sequence.


## Usage

Leiningen dependency information:

	[clj.where "0.1.0"]

For example, you have a vector of key-value maps,such as:

```clj
    (def cats
       [
         {
          :name  "Bubbles"
          :favoriteFood "mice"
          :age 1
         },
         {
          :name "Sparkle"
          :favoriteFood "tuna"
         },
         {
          :name "flyingCat"
          :favoriteFood "mice"
          :age 1
         }
      ])
```

You want to filter with some properties,like:

    user=> (where cats {:age 1})
    ;; ({:age 1, :name "Bubbles", :favoriteFood "mice"} {:age 1, :name "flyingCat", :favoriteFood "mice"})

    user=> (where cats {:age 1 :name "Bubbles"})
    ;; ({:age 1, :name "Bubbles", :favoriteFood "mice"})

    user=> (where cats {:age 1, :favoriteFood "tuna"})
    ;; ()

`where` accepts three arguments: the sequence, the query map, and the optional matcher function.The default matcher function is `=`.You can pass your custom matcher function,the matcher function accepts two arguments: the value in query map  and the value in 'object' map with the same key.


## License

Copyright © 2014 dennis zhuang

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
