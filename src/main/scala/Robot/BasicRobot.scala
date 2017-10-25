package Robot

import scala.annotation.tailrec

/**
  * Worst solution for XspeedIt
  * This Robot just take articles one by one
  * If the size of the package is not enough, it will create a new package
  */
class BasicRobot extends Robot {

  /**
    * @param articles : article List ( each article is represented by an int. this int is his weight)
    * @param MaxWeightByPackage : it's the package max capacity
    * @return : a List of filled Packages
    */
  override def process(articles : List[Int], MaxWeightByPackage : Int) : List[Package] = {
    // take article one by one
      @tailrec
      def subProcess(articles : List[Int], packages: List[Package]) : List[Package] = {
        articles match {
          case a :: as =>
              if (a + packages.head.weight <= MaxWeightByPackage)
                // if the current package can contain the article we add it into it
                 subProcess(as, new Package(a :: packages.head.articles) :: packages.tail)
              else
              // create a new package with the article inside
                subProcess(as, new Package(a) :: packages)
          case Nil => packages
        }
    }
    subProcess(articles, new Package() :: Nil)
  }
}