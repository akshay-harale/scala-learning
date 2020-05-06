/*
 * Copyright © 2012 - 2016 Lightbend, Inc. All rights reserved.
 */

package com.lightbend.training.scalatrain

object TestData {

  val munich = Station("Munich")

  val nuremberg = Station("Nuremberg")

  val ice724MunichTime = Time(8, 50)

  val ice724NurembergTime = Time(10)

  val ice724 = Train("ICE", 724, Vector(ice724MunichTime -> munich, ice724NurembergTime -> nuremberg))
}
