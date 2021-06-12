import PackDuplicates.functional

object ModifiedLengthEncoder extends App {
  def encode[T](ls: List[T]): List[Any] = {
    val packed = functional(ls)
    packed.map { l =>
      val len = l.length
      if (len > 1) (l.head, len)
      else l.head
    }
  }

  def typeSafeEncoder[T](ls: List[T]): List[Either[T, (T, Int)]] = {
    val packed = functional(ls)
    packed.map { l =>
      val len = l.length
      if (len > 1) Right((l.head, len))
      else Left(l.head)
    }
  }

  val input = List(1, 1, 1, 2, 2, 3, 3, 3, 3, 4)
  // val res = encode(input)
  val res = typeSafeEncoder(input)
  println(res)
}
