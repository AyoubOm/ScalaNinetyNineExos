object PackDuplicates extends App {
  def rec[T](ls: List[T]): List[List[T]] = ls match {
    case Nil => Nil
    case x :: xs => ls.takeWhile(_ == x) :: rec(ls.dropWhile(_ == x))
  }

  def tailRec[T](ls: List[T]): List[List[T]] = {
    def helper(ls: List[T], res: List[List[T]]): List[List[T]] = {
      if (ls.isEmpty) res.reverse
      else {
        val (left, right) = ls span (_ == ls.head)
        helper(right, left :: res)
      }
    }
    helper(ls, Nil)
  }

  def functional[T](ls: List[T]): List[List[T]] = ls.foldRight(List[List[T]]()){ (e, res) =>
    if (res.isEmpty || e != res.head.head) List(e) :: res
    else (e :: res.head) :: res.tail
  }


  val input = List(1, 1, 1, 2, 2, 3, 3, 3, 3, 4)
  // val res = rec(input)
  // val res = functional(input)
  val res = tailRec(input)
  println(res)
}
