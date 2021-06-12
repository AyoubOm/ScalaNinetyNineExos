import PackDuplicates.functional

object RunLengthEncoder extends App {
  def encode[T](ls: List[T]): List[(T, Int)] = {
    val packed = functional(ls)
    packed.foldRight(List[(T, Int)]())((curr, res) => (curr.head, curr.length) :: res)
  }

  def theSolution[T](ls: List[T]): List[(T, Int)] = {
    functional(ls) map (l => (l.head, l.length))
  }

  val input = List(1, 1, 1, 2, 2, 3, 3, 3, 3, 4)
  // val res = encode(input)
  val res = theSolution(input)
  println(res)
}
