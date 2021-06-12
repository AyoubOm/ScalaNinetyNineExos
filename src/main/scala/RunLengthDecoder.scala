object RunLengthDecoder extends App {
  def decode[T](ls: List[(T, Int)]): List[T] = ls.flatMap( e => List.fill(e._2)(e._1) )


  val input = List((1,3), (2,2), (3,4), (4,1))

  val res = decode(input)
  println(res)
}
