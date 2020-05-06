import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Trivial extends AnyWordSpec with Matchers {
  "Running a trivial test" should {
    "succeed" in {
      val sum = 1 + 2
      sum shouldBe 3
    }
  }

}
