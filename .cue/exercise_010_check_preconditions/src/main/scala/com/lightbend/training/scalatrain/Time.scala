/*
 * Copyright © 2012 - 2016 Lightbend, Inc. All rights reserved.
 */

package com.lightbend.training.scalatrain

object Time {

  def fromMinutes(minutes: Int): Time =
    new Time(minutes / 60, minutes % 60)
}

class Time(val hours: Int = 0, val minutes: Int = 0) {
  require(hours >= 0 && hours <= 23, "hours must be within 0 and 23")
  require(minutes >= 0 && minutes <= 59, "minutes must be within 0 and 59")

  val asMinutes: Int =
    hours * 60 + minutes

  def minus(that: Time): Int =
    this.asMinutes - that.asMinutes

  def -(that: Time): Int =
    minus(that)
}
