package com.steelcity;

import org.jruby.Ruby;
import org.jruby.RubyObject;
import org.jruby.javasupport.util.RuntimeHelpers;
import org.jruby.runtime.builtin.IRubyObject;
import org.jruby.javasupport.JavaUtil;
import org.jruby.RubyClass;


public class Schedule extends RubyObject  {
    private static final Ruby __ruby__ = Ruby.getGlobalRuntime();
    private static final RubyClass __metaclass__;

    static {
        String source = new StringBuilder("# -*- coding: utf-8 -*-\n" +
            "require 'java'\n" +
            "java_package 'com.steelcity'\n" +
            "\n" +
            "class Schedule\n" +
            "  attr_reader :day\n" +
            "\n" +
            "  PRESENTERS = {\n" +
            "    'Friday' => ['Corey Haines', 'Josh Susser', 'Andrew Clay Shafer', \n" +
            "                 'Steve Klabnik & Lindsey Bieda', 'Mattt Thompson', \n" +
            "                 'Jeff Casimir'],\n" +
            "    'Saturday' => ['Aaron Patterson', 'Jennifer Payne', 'Jim Weirich', \n" +
            "                   'Joe O’Brien'] \n" +
            "  }\n" +
            "\n" +
            "  def initialize(day)\n" +
            "    raise \"Invalid day\" unless [\"Friday\", \"Saturday\"].include?(day)\n" +
            "\n" +
            "    @day = day\n" +
            "  end\n" +
            "\n" +
            "  def speakers\n" +
            "    PRESENTERS[day]\n" +
            "  end\n" +
            "end\n" +
            "").toString();
        __ruby__.executeScript(source, "schedule.rb");
        RubyClass metaclass = __ruby__.getClass("Schedule");
        metaclass.setRubyStaticAllocator(Schedule.class);
        if (metaclass == null) throw new NoClassDefFoundError("Could not load Ruby class: Schedule");
        __metaclass__ = metaclass;
    }

    /**
     * Standard Ruby object constructor, for construction-from-Ruby purposes.
     * Generally not for user consumption.
     *
     * @param ruby The JRuby instance this object will belong to
     * @param metaclass The RubyClass representing the Ruby class of this object
     */
    private Schedule(Ruby ruby, RubyClass metaclass) {
        super(ruby, metaclass);
    }

    /**
     * A static method used by JRuby for allocating instances of this object
     * from Ruby. Generally not for user comsumption.
     *
     * @param ruby The JRuby instance this object will belong to
     * @param metaclass The RubyClass representing the Ruby class of this object
     */
    public static IRubyObject __allocate__(Ruby ruby, RubyClass metaClass) {
        return new Schedule(ruby, metaClass);
    }

    
    public  Schedule(Object day) {
        this(__ruby__, __metaclass__);
        IRubyObject ruby_day = JavaUtil.convertJavaToRuby(__ruby__, day);
        RuntimeHelpers.invoke(__ruby__.getCurrentContext(), this, "initialize", ruby_day);

    }

    
    public Object speakers() {

        IRubyObject ruby_result = RuntimeHelpers.invoke(__ruby__.getCurrentContext(), this, "speakers");
        return (Object)ruby_result.toJava(Object.class);

    }

}
