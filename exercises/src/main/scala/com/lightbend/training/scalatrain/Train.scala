package com.lightbend.training.scalatrain

import scala.collection.immutable.Seq
/**
 * Created by akshay on 06/05/20
 *
 * @author akshay
 *         com.lightbend.training.scalatrain.Train
 */
case class Station(name :String)
case class Train(info:TrainInfo,schedule:Seq[(Time,Station)]) {
  require(schedule.size >= 2,"Schedule must have have at least 2 elements")
  val stations: Seq[Station]  = schedule.map(_._2)

  def timeAt(station: Station):Option[Time] ={
    schedule.find{
      case (_,needle) => needle == station
    }.map(_._1)
  }
}

sealed abstract class TrainInfo {
  def number:Int
}

case class InterCityExpress(number: Int,hasWifi:Boolean = false) extends TrainInfo
case class RegionalExpress( number: Int) extends TrainInfo
case class BavarianRegional( number: Int) extends TrainInfo
