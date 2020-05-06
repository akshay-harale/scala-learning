/*
 * Copyright © 2012 - 2016 Lightbend, Inc. All rights reserved.
 */

package com.lightbend.training.scalatrain

import TestData._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class TrainSpec extends AnyWordSpec with Matchers {

  "Creating a Train" should {
    "throw an IllegalArgumentException for a schedule with 0 or 1 elements" in {
      an[IllegalArgumentException] should be thrownBy Train("ICE", 724, Vector())
      an[IllegalArgumentException] should be thrownBy Train("ICE", 724, Vector(ice724MunichTime -> munich))
    }
  }

  "stations" should {
    "be initialized correctly" in {
      ice724.stations shouldEqual Vector(munich, nuremberg, cologne)
    }
  }
}
