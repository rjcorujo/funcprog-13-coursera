package week04

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  
}


//using val head:T we create a member variable called head, and includes getter
class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  def isEmpty = true
  
  //Nothing, is valid because nothing is a subtype of any other type
  def head: Nothing = throw new NoSuchElementException("Nil.head");
  def tail: Nothing  = throw new NoSuchElementException("Nil.tail");
}