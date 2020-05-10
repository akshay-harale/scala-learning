package com.lightbend.training.scalatrain.typeclass

/**
 * Created by akshay on 10/05/20
 *
 * @author akshay
 *         Animal
 */
trait Animal {

}

case class Dog(name : String) extends Animal
case class Bird(name : String) extends Animal
case class Cat(name : String) extends Animal


trait BehavesLikeHuman[A] {
  def kahipan(a:A):Unit
}
object BehavesLikeHuman {
  def speak[A](a: A)(implicit behavesLikeHumanInstance: BehavesLikeHuman[A]):Unit = {
    behavesLikeHumanInstance.kahipan(a)
  }
}

object BehavesLikeHumanSyntax {
  implicit class BehavesLikeHumanOps[A](value:A) {
    def speak(implicit behavesLikeHumanImpls:BehavesLikeHuman[A]):Unit = {
      behavesLikeHumanImpls.kahipan(value)
    }
  }
}