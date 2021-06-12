package Traits

import org.scalatest.{FlatSpec, Matchers}

class BasicIntQueueTest extends FlatSpec with Matchers {
  "A basic Int Queue" should "get values in the correct order" in {
    val queue = new BasicIntQueue
    queue.put(1)
    queue.put(2)
    queue.get should be (1)
    queue.get should be (2)
  }
  "A basic Int Queue with Doubling" should "get its values doubled" in {
    val queue = new BasicIntQueue with Doubling
    queue.put(1)
    queue.get should be (2)
  }
}
