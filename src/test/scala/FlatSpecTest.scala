import org.scalatest._
import collection.mutable.Stack

class FlatSpecTest extends FlatSpec with Matchers {
  "A Stack" should "pop values in last-in-first-out-order" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    stack.pop() should be (2)
    stack.pop() should be (1)
  }

  it should "throw a No SuchElementException if an empty stack is popped" in {
    val emptyStack = new Stack[Int]
    a [NoSuchElementException] should be thrownBy (emptyStack.pop())
  }

  "An empty Set" should "have size 0" in {
    assert(Set.empty.size == 0)
  }
  it should "produce NoSuchElementException when head is invoked" in {
    intercept[NoSuchElementException] {
      Set.empty.head
    }
  }

}
