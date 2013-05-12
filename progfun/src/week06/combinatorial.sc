package week06


object combinatorial {

	def isPrime(n: Int):Boolean  = (2 until n) forall (d => n % d != 0)
                                                  //> isPrime: (n: Int)Boolean

	val n = 7                                 //> n  : Int = 7
	(1 until n) flatMap (i =>
			(1 until i) map (j => (i,j))) filter (pair => isPrime(pair._1+pair._2))
                                                  //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))

	//for expressions return the list of combinations, yield shows how to bild evey element
	
	for {
		i <- 1 until n
		j <- 1 until i
		if isPrime(i+j)
	} yield (i,j)                             //> res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
	
		def scalarProdFor(xs: List[Double], ys: List[Double]): Double =
			(for {
				(x,y) <- xs zip ys
			} yield (x*y)).sum        //> scalarProdFor: (xs: List[Double], ys: List[Double])Double
	
	
	val xs = List(1.0,2.0)                    //> xs  : List[Double] = List(1.0, 2.0)
	val ys = List(1.0,2.0)                    //> ys  : List[Double] = List(1.0, 2.0)
	scalarProdFor(xs, ys)                     //> res2: Double = 5.0
	
}