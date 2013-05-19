package week07

object streams {
  	val xs = Stream.cons(1, Stream.cons(3, Stream.empty))
                                                  //> xs  : Stream.Cons[Int] = Stream(1, ?)
 
 		Stream(1,2,3)                     //> res0: scala.collection.immutable.Stream[Int] = Stream(1, ?)
 
 		def isPrime(n: Int):Boolean  = (2 until n) forall (d => n % d != 0)
                                                  //> isPrime: (n: Int)Boolean
    
    //performance problems we only want element 1
	  ((1000 to 10000) filter isPrime)(1)     //> res1: Int = 1013
	  
	  
	  
	  
	  def streamRange(lo: Int, hi: Int): Stream[Int] =
	  	if (lo >= hi) Stream.empty
			else Stream.cons(lo,streamRange(lo+1,hi))
                                                  //> streamRange: (lo: Int, hi: Int)Stream[Int]
//			else lo #:: streamRange(lo+1,hi) cons operator #:: for streams
                                                  
		((1000 to 50000) filter isPrime)(1)
                                                  //> res2: Int = 1013
 
 		(streamRange(1000,100000) filter isPrime)(1)
                                                  //> res3: Int = 1013
		streamRange(1,10).take(3).toList  //> res4: List[Int] = List(1, 2, 3)
		
		//infinite structures
		def from(n: Int): Stream[Int] = n #:: from(n+1)
                                                  //> from: (n: Int)Stream[Int]

		(from(10) filter (x => x % 10 == 0))(5000)
                                                  //> res5: Int = 50010

	
}