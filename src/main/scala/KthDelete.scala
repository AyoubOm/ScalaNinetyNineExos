/*
Return the list and the removed element in a Tuple. Elements are numbered from 0.
Example:

scala> removeAt(1, List('a, 'b, 'c, 'd))
res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
 */

object KthDelete extends App {
  def removeAt[T](k: Int, ls: List[T]): (List[T], T) = (k, ls) match {
    case (_, Nil) => throw new NoSuchElementException
    case (0, x :: xs) => (xs, x)
    case (k, x :: xs) => {
      val subRes = removeAt(k - 1, xs)
      (x :: subRes._1, subRes._2)
    }
  }
  val input = List('a, 'b, 'c, 'd)
  val res = removeAt(0, input)
  println(res)
}
