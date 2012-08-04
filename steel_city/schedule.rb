# -*- coding: utf-8 -*-
require 'java'
java_package 'com.steelcity'

class Schedule
  attr_reader :day

  PRESENTERS = {
    'Friday' => ['Corey Haines', 'Josh Susser', 'Andrew Clay Shafer', 
                 'Steve Klabnik & Lindsey Bieda', 'Mattt Thompson', 
                 'Jeff Casimir'],
    'Saturday' => ['Aaron Patterson', 'Jennifer Payne', 'Jim Weirich', 
                   'Joe O’Brien'] 
  }

  def initialize(day)
    raise "Invalid day" unless ["Friday", "Saturday"].include?(day)

    @day = day
  end

  def speakers
    PRESENTERS[day]
  end
end
