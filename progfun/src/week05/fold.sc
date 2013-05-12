object fold {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def mapFun[T,U](xs: List[T], f: T => U): List[U] =
  	(xs foldRight List[U]())(f(_) :: _)       //> mapFun: [T, U](xs: List[T], f: T => U)List[U]
  	
  	
	def lengthFun[T](xs: List[T]): Int =
		(xs foldRight 0)((x:T,y:Int) => 1 + y)
                                                  //> lengthFun: [T](xs: List[T])Int
  	
  val sample = List(1,2,3,4,5,6,7)                //> sample  : List[Int] = List(1, 2, 3, 4, 5, 6, 7)
 	mapFun(sample,((x:Int) => x*x))           //> res0: List[Int] = List(1, 4, 9, 16, 25, 36, 49)
 	lengthFun(sample)                         //> res1: Int = 7
}