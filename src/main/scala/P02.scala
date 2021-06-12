import scala.annotation.tailrec

object P02 {
  def lastButOne[T](xs: List[T]): T = xs match {
    case x :: _ :: Nil => x
    case _ :: ys => lastButOne(ys)
    case _ => throw new NoSuchElementException
  }

  @tailrec
  def lastNth[T](xs: List[T], n: Int): T = {
    if (n <= 0 || n > xs.size) throw new NoSuchElementException
    else if (n == xs.size) xs.head
    else lastNth(xs.tail, n)
  }


  def main(args: Array[String]): Unit = {
    // println(lastButOne(List(4)))
    println(lastNth(List(1, 2, 3, 4), 0))
  }
}
