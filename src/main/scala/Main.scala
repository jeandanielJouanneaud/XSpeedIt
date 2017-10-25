import Robot.{BasicRobot, BetterRobot}

object Main
{
  def isAllDigits(x : String) = x forall Character.isDigit

  def toInt(s : String) : Option[Int] = {
    try {
      Some(s.toInt)
    } catch {
      case _: Exception => None
    }
  }

  def main(args: Array[String]): Unit = {
    println("Please enter an article integer list")

    var inputArticles = scala.io.StdIn.readLine()

    while(!isAllDigits(inputArticles))
      {
        println("ERROR, the line must contain only digits !")
        println("Please enter an article integer list")

        inputArticles = scala.io.StdIn.readLine()
      }

    val articles = inputArticles.map(_.asDigit).toList

    val maxWeight = articles.max

    println("Please Enter the maximum package capacity")
    var inputCapacity = scala.io.StdIn.readLine()
    var capacity = toInt(inputCapacity)

    while(capacity.isEmpty | capacity.get < maxWeight)
    {
        println(s"""ERROR, the capacity must be a number greater or equal to $maxWeight!""")
        println("Please Enter the maximum package capacity")
        inputCapacity = scala.io.StdIn.readLine()
        capacity = toInt(inputCapacity)
    }

    val packagesBasicRobot = new BasicRobot().process(articles, capacity.get)
    val packagesBetterRobot = new BetterRobot().process(articles, capacity.get)

    println(s""" BasicRobot => ${packagesBasicRobot.length} package(s)""")
    println(packagesBasicRobot.map(_.toString).mkString("/").reverse)
    println(s""" BetterRobot => ${packagesBetterRobot.length} package(s)""")
    println(packagesBetterRobot.map(_.toString).mkString("/").reverse)
  }
}
