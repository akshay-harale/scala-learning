/*
 * Copyright © 2012 - 2016 Lightbend, Inc. All rights reserved.
 */

package com.lightbend.training.scalatrain

class JourneyPlanner(trains: Set[Train]) {

  val stations: Set[Station] =
    // Could also be expressed in short notation: trains flatMap (_.stations)
    trains.flatMap(train => train.stations)
}
