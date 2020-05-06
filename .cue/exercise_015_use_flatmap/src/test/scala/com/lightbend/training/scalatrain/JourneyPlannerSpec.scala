/*
 * Copyright © 2012 - 2016 Lightbend, Inc. All rights reserved.
 */

package com.lightbend.training.scalatrain

import TestData._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class JourneyPlannerSpec extends AnyWordSpec with Matchers {

  "stations" should {
    "be initialized correctly" in {
      planner.stations shouldEqual Set(munich, nuremberg, cologne, essen)
    }
  }
}
