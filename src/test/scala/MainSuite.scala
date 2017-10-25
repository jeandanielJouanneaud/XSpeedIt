import Robot.{BasicRobot, BetterRobot}
import org.scalatest.FlatSpec

class MainSuite extends FlatSpec {

  "the toInt method" should "give a correct result" in {
    val articlesString = "123456"

    val expected = 123456

    val res = Main.toInt(articlesString)

    assert(res.isDefined && res.get == expected)
  }

  "the isAllDigits method" should "give a good result" in {
    val articlesString = "1234522"

    val res = Main.isAllDigits(articlesString)

    assert(res)
  }


  "the isAllDigits method" should "not give a good result" in {
    val articlesString = "1234a522"

    val res = Main.isAllDigits(articlesString)

    assert(!res)
  }
}
