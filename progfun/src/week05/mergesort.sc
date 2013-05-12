object mergesort {

	def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
		val n = xs.length/2
		if (n == 0) xs
		else {
			def merge(xs: List[T], ys: List[T]): List[T] = (xs,ys) match {
				case (z::zs, w::ws) => {
					if (ord.lt(z,w)) z :: merge(zs, w::ws)
					else w :: merge(xs,ws)
				}
				case (Nil, ws) => ws
				case (zs, Nil) => zs
			}
			val (first,second) = xs splitAt(n)
			merge(msort(first),msort(second))
		}
	}                                         //> msort: [T](xs: List[T])(implicit ord: Ordering[T])List[T]

	
	
	val nums = List(5,3,2,10,1,25,20,14,14,16,12,19)
                                                  //> nums  : List[Int] = List(5, 3, 2, 10, 1, 25, 20, 14, 14, 16, 12, 19)
	msort(nums)                               //> res0: List[Int] = List(1, 2, 3, 5, 10, 12, 14, 14, 16, 19, 20, 25)
	
	val fruits = List("apple","pinneaple","orange","banana")
                                                  //> fruits  : List[java.lang.String] = List(apple, pinneaple, orange, banana)
  msort(fruits)(Ordering.String)                  //> res1: List[java.lang.String] = List(apple, banana, orange, pinneaple)

	//implicit types
}