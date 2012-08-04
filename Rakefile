task :clean do
  system "rm -rf ~/.m2/repository/{schedule, jruby}"
end

task :compile => :clean do
  system "jrubyc --javac steel_city/schedule.rb -t build/"
  system "jrubyc build/com/steelcity/schedule.java"

  system "jar -cf lib/schedule.jar build/com/steelcity/schedule.class"
  system "cp \`which jruby | sed 's/bin\\/jruby//'\`/lib/jruby.jar lib/"
end

task :install => :compile do
  [['schedule', '0.0.0'], ['jruby', '1.6.7.2']].each do |(package, version)|
    cmd = <<-CMD
      mvn install:install-file \
        -DgroupId=#{package} \
        -DartifactId=#{package} \
        -Dversion=#{version} \
        -Dpackaging=jar \
        -Dfile=./lib/#{package}.jar
    CMD

    system cmd
  end
end
