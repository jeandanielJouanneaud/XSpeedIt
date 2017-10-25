package Robot

/**
  * this class represents the article container
  * @param articles
  */
class Package(val articles : List[Int]) {

  def this() = this(List())
  def this(article : Int) = this(article :: Nil)

  def weight = articles.sum

  override def toString: String = {
    articles.mkString("")
  }
}
