/*
 * Copyright © 2012 - 2016 Lightbend, Inc. All rights reserved.
 */

package com.lightbend.training.scalatrain

case class Train(info: TrainInfo, schedule: Seq[(Time, Station)]) {
  require(schedule.size >= 2, "schedule must contain at least two elements")


  val stations: Seq[Station] =
    // Could also be expressed in short notation: schedule map (_._2)
    schedule.map(stop => stop._2)

  def timeAt(station: Station): Option[Time] =
    // Could also be expressed in notation: schedule find (_._2 == station) map (_._1)
    schedule.find(stop => stop._2 == station).map(found => found._1)
}

case class Station(name: String)

sealed abstract class TrainInfo {
  def number: Int
}
case class InterCityExpress(number: Int, hasWifi: Boolean = false) extends TrainInfo
case class RegionalExpress(number: Int) extends TrainInfo
case class BavarianRegional(number: Int) extends TrainInfo
