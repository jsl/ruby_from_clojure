# Running Ruby from Clojure

This is a simple example of calling Ruby from Clojure. It contains a simple
JRuby project and a Clojure project:

* steel_city - a Ruby project that returns the speakers for the given day
  in the Steel City Ruby Conference 2012
* speaker_selector - Returns a "top" speaker for the given day using a 
  sophisticated algorithm (ie, random selection)

## Compiling

    cd steel_city
    jrubyc --javac schedule.rb
    jar -cf schedule.jar com/steelcity/Schedule.class

## Installing with mvn

In your clojure project, set up the dependencies in the project.clj. 
You will need dependencies on jruby and your compiled jar.

You will have to install these with mvn so that lein deps loads the
dependencies:

    mvn install:install-file -DgroupId=com.steelcity.schedule \
    	-DartifactId=com.steelcity.schedule -Dversion=0.0.0 \
	-Dpackaging=jar -Dfile=schedule.jar

The command to install jruby to your local mvn repository will be similar.

