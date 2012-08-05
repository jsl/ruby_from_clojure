desc "Remove build artifacts"
task :clean do
  # Remove any cached builds from the local maven repo
  system "rm -rf ~/.m2/repository/com/steelcity"
  system "rm -rf ~/.m2/repository/jruby"

  # Remove any installed deps in the clojure project
  system "rm -rf speaker_selector/lib/*"

  # Remove compliled clojure classes
  system "cd speaker_selector && lein clean"

  # Remove Java classes compliled with JRuby
  system "rm -rf build"
end

task :compile_ruby do
  mkdir_p "build/jar"

  # Compile Ruby into Java source and bytecode
  system "cd steel_city && jrubyc --javac schedule.rb -t ../build"

  # Jar up Ruby bytecode for including into the clojure project
  system "cd build && jar -cf jar/schedule.jar com/steelcity/Schedule.class"

  # Copy JRuby library for including into the clojure project
  system "cp \`which jruby | sed 's/bin\\/jruby//'\`/lib/jruby.jar build/jar/"
end

desc "Compile Ruby into Java bytecode"
task :compile => [:clean, :compile_ruby]

desc "Install and copy to Clojure project"
task :install => :compile do
  # Install compiled Ruby with Maven
  system <<-CMD
    cd speaker_selector &&
    mvn install:install-file \
    -DgroupId=com.steelcity \
    -DartifactId=schedule \
    -Dversion=0.0.0 \
    -Dpackaging=jar \
    -Dfile=../build/jar/schedule.jar
  CMD

  # Install JRuby lib with Maven
  system <<-CMD
    cd speaker_selector &&
    mvn install:install-file \
    -DgroupId=jruby \
    -DartifactId=jruby \
    -Dversion=1.6.7.2 \
    -Dpackaging=jar \
    -Dfile=../build/jar/jruby.jar
  CMD

  # Copy the installed deps into the clojure project
  system "cd speaker_selector && lein deps"
end

desc "Start leiningen repl"
task :run => :install do
  # Open repl with leiningen
  system "cd speaker_selector && lein repl"
end

task :default => :run
