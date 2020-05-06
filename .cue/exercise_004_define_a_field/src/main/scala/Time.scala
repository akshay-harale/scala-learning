/*
 * Copyright © 2012 - 2016 Lightbend, Inc. All rights reserved.
 */

class Time(val hours: Int, val minutes: Int) {
  // TODO Verify that `hours` is within 0 and 23
  // TODO Verify that `minutes` is within 0 and 59

  val asMinutes: Int =
    hours * 60 + minutes
}
