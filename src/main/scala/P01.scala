object P01 {

  def last[T](xs: List[T]): Option[T] = {
    xs match {
      case Nil => None
      case x :: Nil => Some(x)
      case x :: rest => last(rest)
    }
  }

  def main(args: Array[String]): Unit = {
    println(last(List()))
  }
}
