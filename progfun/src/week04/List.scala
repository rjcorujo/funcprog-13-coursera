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

object List {
  def apply[T](): List[T] = new Nil
  
  
  def apply[T](elem1: T): List[T] = new Cons[T](elem1, new Nil)
  
  def apply[T](elem1: T, elem2: T): List[T] = new Cons[T](elem1, new Cons(elem2, new Nil)) 
  
  
}