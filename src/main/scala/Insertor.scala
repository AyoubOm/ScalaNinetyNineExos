/*
 Insert an element at a given position into a list.
Example:
scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)
 */

object Insertor extends App {
  def insertAt[T](e: T, k: Int, ls: List[T]): List[T] = {
    if (k < 0 || (k > 0 && ls.isEmpty)) throw new NoSuchElementException
    (k, ls) match {
      case (0, ls) => e :: ls
      case (k, x :: xs) => x :: insertAt(e, k-1, xs)
    }
  }

  val res = insertAt('new, 5, List('a, 'b, 'c, 'd))
  println(res)
}
