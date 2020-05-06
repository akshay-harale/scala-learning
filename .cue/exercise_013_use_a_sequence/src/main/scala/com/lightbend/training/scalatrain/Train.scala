/*
 * Copyright © 2012 - 2016 Lightbend, Inc. All rights reserved.
 */

package com.lightbend.training.scalatrain

case class Train(kind: String, number: Int, schedule: Seq[Station]) {
  require(schedule.size >= 2, "schedule must contain at least two elements")
}

case class Station(name: String)
