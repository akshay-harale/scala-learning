package com.lightbend.training.scalatrain

/**
 * Created by akshay on 07/05/20
 *
 * @author akshay
 *         JourneyPlanner
 */
class JourneyPlanner(trains: Set[Train]) {
  val stations: Set[Station] = trains.flatMap(_.stations)

  def trainsAt(station: Station):Set[Train] = trains.filter(train=>train.stations.contains(station))

  def stopsAt(station: Station):Set[(Time,Train)]= {
    for{
      train <-  trains
      time <- train.timeAt(station)
    } yield time -> train
  }

  def isShortTripF(from:Station,to:Station) = {
    trains.exists(train => train.stations.dropWhile(_==from).take(2).contains(to))
  }
  def isShortTrip(from:Station,to:Station):Boolean = {
    trains.exists(_.stations.dropWhile(_!=from) match {
      case `from` +: `to` +: _ => true
      case `from` +: _ +: `to` +: _ => true
      case _ => false
    })
  }


}
