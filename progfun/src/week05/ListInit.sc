import scala.List;

object ListInit {
  def init[T](xs: List[T]): List[T] = xs match {
  	case List() =>throw new Error("init of empty")
  	case List(x) => List()
  	case y :: ys => y :: init(ys)
  }                                               //> init: [T](xs: List[T])List[T]
  
  val l = List(1,2,3)                             //> l  : List[Int] = List(1, 2, 3)
  
  init(l)                                         //> res0: List[Int] = List(1, 2)
  
  def removeAt[T](n: Int, xs: List[T]):List[T] = (xs take n) ::: (xs drop n+1)
                                                  //> removeAt: [T](n: Int, xs: List[T])List[T]
  
  removeAt(0,List(1,2,3))                         //> res1: List[Int] = List(2, 3)
  removeAt(1,List(1,2,3))                         //> res2: List[Int] = List(1, 3)
  removeAt(2,List(1,2,3))                         //> res3: List[Int] = List(1, 2)
  removeAt(3,List(1,2,3))                         //> res4: List[Int] = List(1, 2, 3)
  
  def flatten(xs:List[Any]) : List[Any] = xs match {
  	case List() => xs
  	case (z :: zs) :: ys => flatten(z::zs) ::: flatten(ys)
  	case y :: ys => y :: flatten(ys)
  }                                               //> flatten: (xs: List[Any])List[Any]
  
  flatten(List(1,List(1,2,3),List(1,List(2,3))))  //> res5: List[Any] = List(1, 1, 2, 3, 1, 2, 3)
}