/*
Given two indices, I and K, the slice is the list containing the elements from and including the Ith element up to but not including the Kth element of the original list. Start counting the elements with 0.
Example:

scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: List[Symbol] = List('d, 'e, 'f, 'g)
 */

object SliceExtractor extends App {
  def slice[T](i: Int, k: Int, ls: List[T]) = (ls take k) drop i

  def slice2[T](i: Int, k: Int, ls: List[T]) = ls.slice(i, k)

  def slice3[T](i: Int, k: Int, ls: List[T]) : List[T] = {
    def helper(i: Int, k: Int, ls: List[T], count: Int): List[T] = (ls, count) match {
      case (_, k) => Nil
      case (Nil, nb) if nb < k => throw new NoSuchElementException
      case (x :: xs, nb) if nb < i => helper(i, k, ls, count+1)
      case (x :: xs, nb) if nb >= i && nb < k => {
        println("Im here")
        x :: helper(i, k, ls, count+1)
      }
    }
    if (i < 0) throw new NoSuchElementException
    helper(i, k, ls, 0)
  }



  val res = slice3(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  println(res)
}
