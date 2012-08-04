task :clean do
  system "rm -rf ~/.m2/repository/com/steelcity"
  system "rm -rf ~/.m2/repository/jruby"

  system "rm -rf speaker_selector/lib/*"

  system "cd speaker_selector && lein clean"

  system "rm -rf build"
  mkdir_p "build/jar"
end

task :compile_ruby do
  system "cd steel_city && jrubyc --javac schedule.rb -t ../build"

  system "cd build && jar -cf jar/schedule.jar com/steelcity/Schedule.class"
  system "cp \`which jruby | sed 's/bin\\/jruby//'\`/lib/jruby.jar build/jar/"
end

task :compile => [:clean, :compile_ruby]

task :install => :compile do
  system <<-CMD
    cd speaker_selector &&
    mvn install:install-file -DgroupId=com.steelcity -DartifactId=schedule -Dversion=0.0.0 -Dpackaging=jar -Dfile=../build/jar/schedule.jar
  CMD

  system <<-CMD
    cd speaker_selector &&
    mvn install:install-file -DgroupId=jruby -DartifactId=jruby -Dversion=1.6.7.2 -Dpackaging=jar -Dfile=../build/jar/jruby.jar
  CMD

  system "cd speaker_selector && lein deps"
end

task :run => :install do
  system "cd speaker_selector && lein repl"
end
