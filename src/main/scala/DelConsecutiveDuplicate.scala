import scala.annotation.tailrec

object DelConsecutiveDuplicate extends App {
  def mySolution[T](ls: List[T]): List[T] = {
    @tailrec
    def helper(ls: List[T], last: T, res: List[T]): List[T] = {
      ls match {
        case Nil => res
        case x :: xs if x != last => helper(xs, x, res :+ x)
        case x :: xs => helper(xs, x, res)
      }
    }
    ls match {
      case Nil => Nil
      case x :: xs => helper(xs, x, List(x))
    }
  }

  // time complexity of drop while : O(K) while K are the dropped elements => O(N) time
  def recursive[T](ls: List[T]): List[T] = ls match {
    case Nil => Nil
    case x :: xs => x :: recursive(xs.dropWhile(curr => curr == x))
  }

  // Note the use of prepend and reverse to have O(N) time complexity
  def tailRec[T](ls: List[T]): List[T] = {
    def helper(ls: List[T], res : List[T]): List[T] = ls match {
      case Nil => res.reverse
      case x :: xs => helper(xs.dropWhile(curr => curr == x), x :: res)
    }
    helper(ls, Nil)
  }

  def foldRight[T](ls: List[T]): List[T] = ls.foldRight(List[T]()){ (x, res) =>
      if (res.isEmpty || x != res.head) x :: res
      else res
  }


  val input = List(0, 1, 1, 1, 2, 2, 1, 3, 3, 3)
  // val res = mySolution(input)
  // val res = recursive(input)
  // val res = tailRec(input)
  val res = foldRight(input)
  println(res)

}
