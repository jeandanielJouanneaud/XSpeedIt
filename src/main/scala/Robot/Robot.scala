package Robot

/**
  * Each Robot must have a process method
  */
trait Robot {

  def process(articles : List[Int], MaxWeightByPackage : Int) : List[Package] = ???
}
