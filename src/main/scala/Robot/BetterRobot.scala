package Robot

/**
  * Better solution for XSpeedIt
  */
class BetterRobot() extends Robot {

  override def process(articles : List[Int], MaxWeightByPackage : Int) : List[Package] = {
    var minPackage = Int.MaxValue
    var solution : List[Package] = List()

    def subProcess(articles : List[Int], packages : List[Package], nbPackages : Int) : Unit = {
      articles match {
        case a :: as =>
          packages.foreach(p => {
            // we try to put the article in each package
            if(a + p.weight <= MaxWeightByPackage) {
              // if yes we create a new package which contains the article and the rest of the current package.
              // we also exclude the current package from the list
              subProcess(as, new Package(a :: p.articles) :: packages.filter(pa => pa != p), nbPackages)
            }

            if(nbPackages >= minPackage) // optimization : no need to check further. the solution is worse
              return
          })

          subProcess(as, new Package(a) :: packages, nbPackages + 1)

        case Nil => // on a leaf, check if the solution is better than the previous one
          if(nbPackages < minPackage) {
            minPackage = nbPackages
            solution = packages
          }
      }
    }
    subProcess(articles, new Package() :: Nil, 0)
    solution
  }
}
