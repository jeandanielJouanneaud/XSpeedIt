import Robot.{BasicRobot, BetterRobot}
import org.scalatest.FlatSpec

class PackageSuite extends FlatSpec{
  "A package" should "give a correct weight" in {
    val articlesString = "163841689525773"
    val articles = articlesString.map(_.asDigit).toList

    val pack = new Robot.Package(articles)

    val weight = pack.weight

    val expectedSum = 75

    assert(weight == expectedSum)
  }

  "A Package with no articles" should "give a 0 sum" in {
    val pack = new Robot.Package()

    val weight = pack.weight

    val expectedSum = 0

    assert(weight == expectedSum)
  }
}
