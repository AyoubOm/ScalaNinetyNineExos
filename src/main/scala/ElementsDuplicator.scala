object ElementsDuplicator extends App {
  def duplicate[T](ls: List[T]): List[T] = ls.flatMap(e => List(e, e))

  def duplicate2[T](ls: List[T]): List[T] = ls.foldRight(List[T]())((e, res) => e :: e :: res)



  val input = (1 to 10000000).toList
  val t0 = System.nanoTime()
  val res = duplicate(input)
  // val res = duplicate2(input)
  val t1 = System.nanoTime()
  // println(res)
  println(s"Time elapsed = ${(t1 - t0)/1000000}ms")
}
