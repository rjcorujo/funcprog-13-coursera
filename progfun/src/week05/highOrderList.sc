object highOrderList {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def squareList(xs: List[Int]): List[Int] = xs match {
  	case Nil => Nil
  	case y::ys => y*y :: squareList(ys)
  }                                               //> squareList: (xs: List[Int])List[Int]
  
  def squareListMap(xs : List[Int]): List[Int] = xs map ((x: Int) => x*x)
                                                  //> squareListMap: (xs: List[Int])List[Int]
  
  squareList(List(1,2,3,4,5))                     //> res0: List[Int] = List(1, 4, 9, 16, 25)
  squareListMap(List(1,2,3,4,5))                  //> res1: List[Int] = List(1, 4, 9, 16, 25)
  
 	val nums = List(5,3,2,10,1,25,20,14,14,16,12,19)
                                                  //> nums  : List[Int] = List(5, 3, 2, 10, 1, 25, 20, 14, 14, 16, 12, 19)
  
	val fruits = List("apple","pinneaple","orange","banana")
                                                  //> fruits  : List[java.lang.String] = List(apple, pinneaple, orange, banana)
	
	//built-in
	
	nums filter (x => x > 0)                  //> res2: List[Int] = List(5, 3, 2, 10, 1, 25, 20, 14, 14, 16, 12, 19)
	nums filterNot (x => x > 0)               //> res3: List[Int] = List()
  nums partition (x => x < 10)                    //> res4: (List[Int], List[Int]) = (List(5, 3, 2, 1),List(10, 25, 20, 14, 14, 16
                                                  //| , 12, 19))
 //prefix that satisfies criteria
  nums takeWhile (x => x < 10)                    //> res5: List[Int] = List(5, 3, 2)
  nums dropWhile (x => x < 10)                    //> res6: List[Int] = List(10, 1, 25, 20, 14, 14, 16, 12, 19)
  nums span (x => x < 10)                         //> res7: (List[Int], List[Int]) = (List(5, 3, 2),List(10, 1, 25, 20, 14, 14, 16
                                                  //| , 12, 19))
                                                  
	def pack[T](xs: List[T]): List[List[T]] = xs match {
		case Nil  => Nil
		case y :: ys => {
			val (sequence, rest) = (xs span(x => x == y))
			sequence :: pack(rest)
		}
	}                                         //> pack: [T](xs: List[T])List[List[T]]
	
	val data = List("a","a","a","b","b","d","a","a","e","e","i")
                                                  //> data  : List[java.lang.String] = List(a, a, a, b, b, d, a, a, e, e, i)
	pack(data)                                //> res8: List[List[java.lang.String]] = List(List(a, a, a), List(b, b), List(d)
                                                  //| , List(a, a), List(e, e), List(i))
  
  
  def encode[T](xs: List[T]):List[(T,Int)] = {
  	pack(xs) map (zs => (zs.head,zs.length))
  }                                               //> encode: [T](xs: List[T])List[(T, Int)]
 
 	List((1,2),(1,2))                         //> res9: List[(Int, Int)] = List((1,2), (1,2))
  
 	encode(data)                              //> res10: List[(java.lang.String, Int)] = List((a,3), (b,2), (d,1), (a,2), (e,
                                                  //| 2), (i,1))
            
 pack(data).head                                  //> res11: List[java.lang.String] = List(a, a, a)
 
 //short way

	val list = List(1,2,3,4,5)                //> list  : List[Int] = List(1, 2, 3, 4, 5)
	def sum(xs: List[Int]):Int = (0:: xs) reduceLeft (_ + _)
                                                  //> sum: (xs: List[Int])Int
	def sum2(xs: List[Int]):Int = (xs foldLeft 0)(_ + _)
                                                  //> sum2: (xs: List[Int])Int
  sum2(list)                                      //> res12: Int = 15
}