object ElementsDropper extends App {
  def dropNth[T](ls: List[T], n: Int): List[T] = {
    def helper[T](ls: List[T], count: Int) : List[T] = {
      if (ls.isEmpty) Nil
      else if (count % n == 0) helper(ls.tail, count+1)
      else ls.head :: helper(ls.tail, count+1)
    }
    helper(ls, 1)
  }

  val input = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j)
  val res = dropNth(input, 3)
  println(res)

}
