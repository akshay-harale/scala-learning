package com.lightbend.training.scalatrain

import com.lightbend.training.scalatrain.typeclass.{BehavesLikeHuman, Dog}

/**
 * Created by akshay on 10/05/20
 *
 * @author akshay
 *         Executer
 */
object SpeakerObj {

  implicit class Speaker[A](a: A) {
    def speak(implicit bhehaviousr: BehavesLikeHuman[A]): Unit = {
      bhehaviousr.kahipan(a)
    }
  }

}
object Executor extends App {

  implicit val differentDog: BehavesLikeHuman[Dog] = dog => println(s"Hi I am ${dog}, I speak another language")

  val rover = Dog("Rover")
  val lab = Dog("Lab")
//  BehavesLikeHuman.speak(rover)
//  BehavesLikeHuman.speak(lab)
  import SpeakerObj.Speaker
  rover.speak
}



