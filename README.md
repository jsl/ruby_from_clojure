# Ruby from Clojure

This is a simple example of calling Ruby from Clojure. It contains a simple
JRuby project and a Clojure project:

* `steel_city` - a Ruby project that returns the speakers for the given day
  in the Steel City Ruby Conference 2012
* `speaker_selector` - Returns a "top" speaker for the given day using a 
  sophisticated algorithm (ie, random selection)

## Running

    $ rake

    => (import com.steelcity.Schedule)
    => (top-speaker "Friday")
    => (top-speaker "Saturday")

## How does this work?

For detailed instructions on how to get this working with your own Ruby code,
have a look at the `Rakefile`

    rake clean    # Remove build artifacts
    rake compile  # Compile Ruby into Java bytecode
    rake install  # Install and copy to Clojure project
    rake run      # Start leiningen repl
