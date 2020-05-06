package com.lightbend.training.scalatrain

/**
 * Created by akshay on 06/05/20
 *
 * @author akshay
 *         com.lightbend.training.scalatrain.Time
 */

object Time {
  def fromMinutes(m: Int) : Time = {
    val hours= m / 60
    val minutes = m % 60
    Time(hours,minutes)
  }
}

case class Time(hours: Int = 0 , minutes: Int  = 0) {
  require(hours >= 0 && hours <= 23,"hours should be between 0 and 23")
  require(minutes >=0 && minutes <= 59,"minutes should be between 0 and 59")
  // TODO: Verify that hours is within 0 and 23
  // TODO: Verify that minutes is within 0 and 59
  val asMinutes: Int = hours * 60 + minutes

  def minus(that: Time): Int = asMinutes - that.asMinutes

  def -(that: Time): Int = minus(that)
}
