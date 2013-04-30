object week2 {
	//function that
  def product(f : Int => Int)(a:Int, b: Int): Int =
  	if (a > b) 1
  	else f(a) * product(f)(a + 1,b)           //> product: (f: Int => Int)(a: Int, b: Int)Int
 
  def identity(a: Int): Int =
  	a                                         //> identity: (a: Int)Int
 
 product(identity)(1,5)                           //> res0: Int = 120
 product(x => x)(1,5)                             //> res1: Int = 120
 
 def factorial(a: Int): Int =
 	product(x => x)(1,a)                      //> factorial: (a: Int)Int
 	
 	factorial(5)                              //> res2: Int = 120
 	
 	
 	//Generalize product and sum
 	def mapReduce(f: Int => Int, combineFunc: (Int,Int) => Int, identityValue: Int)(init: Int, end :Int): Int =
 		if (init > end) identityValue
 		else combineFunc(f(init),mapReduce(f,combineFunc,identityValue)(init+1,end))
                                                  //> mapReduce: (f: Int => Int, combineFunc: (Int, Int) => Int, identityValue: In
                                                  //| t)(init: Int, end: Int)Int
                                                  
	//generalization for sum
	mapReduce(identity,(a,b) => a + b,0)(1,5) //> res3: Int = 15
	mapReduce(identity,(a,b) => a*b, 1)(1,5)  //> res4: Int = 120

}