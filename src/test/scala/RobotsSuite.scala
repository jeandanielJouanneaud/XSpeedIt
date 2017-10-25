import Robot.{BasicRobot, BetterRobot}
import org.scalatest.FlatSpec

class RobotsSuite extends FlatSpec{

  "A good Basic Robot" should "give a correct bad package" in {
    val articlesString = "163841689525773"
    val MaxWeightByPackage = 10

    val articles = articlesString.map(_.asDigit).toList
    val packs = new BasicRobot().process(articles, MaxWeightByPackage)

    val res = packs.map(_.toString).mkString("/").reverse
    val packsNumber = packs.length

    val expected = "163/8/41/6/8/9/52/5/7/73"
    val expectedNumber = 10

    assert(res == expected)
    assert(packsNumber == expectedNumber)
  }

  "A good Better Robot" should "give a correct better package" in {
    val articlesString = "163841689525773"
    val MaxWeightByPackage = 10

    val articles = articlesString.map(_.asDigit).toList
    val packs = new BetterRobot().process(articles, MaxWeightByPackage)

    val res = packs.map(_.toString).mkString("/").reverse
    val packsNumber = packs.length

    val expected = "163/81/46/9/82/55/7/73"
    val expectedNumber = 8

    assert(res == expected)
    assert(packsNumber == expectedNumber)
  }
}
