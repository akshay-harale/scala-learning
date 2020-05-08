package com.lightbend.training.scalatrain

import play.api.libs.json.{JsNumber, JsObject, JsValue}

import scala.util.{Failure, Success, Try}

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

  def fromJson(js:JsValue):Option[Time] = {
//    Try(Time(
//      Try((js \ "hours").as[Int]).get,
//      Try((js \ "minutes").as[Int]).getOrElse(0)
//    )) match {
//      case Success(value) =>Some(value)
//      case Failure(_) => None
//    }
    for {
      hours <- Try((js \ "hours").as[Int])
      minutes <- Try((js \ "minutes").as[Int]).recover{case _ => 0}
    } yield Time(hours,minutes)
  }.toOption
}

case class Time(hours: Int = 0 , minutes: Int  = 0) extends Ordered[Time] {
  require(hours >= 0 && hours <= 23,"hours should be between 0 and 23")
  require(minutes >=0 && minutes <= 59,"minutes should be between 0 and 59")
  val asMinutes: Int = hours * 60 + minutes

  def minus(that: Time): Int = asMinutes - that.asMinutes

  def -(that: Time): Int = minus(that)

  override lazy val toString: String = f"$hours%02d:$minutes%02d"

  def compare(that: Time): Int = this.asMinutes - that.asMinutes

  def toJson: JsValue = JsObject(
    Map("hours"->JsNumber(hours),("minutes"->JsNumber(minutes)))
  )

}
