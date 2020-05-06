/*
 * Copyright © 2012 - 2016 Lightbend, Inc. All rights reserved.
 */

package com.lightbend.training.scalatrain

class Time(val hours: Int = 0, val minutes: Int = 0) {
  // TODO Verify that `hours` is within 0 and 23
  // TODO Verify that `minutes` is within 0 and 59

  val asMinutes: Int =
    hours * 60 + minutes

  def minus(that: Time): Int =
    this.asMinutes - that.asMinutes

  def -(that: Time): Int =
    minus(that)
}
