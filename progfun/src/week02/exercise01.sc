package week2

object exercise {
  
  def gcd(a: Integer, b: Integer): Integer =
  	if (b == 0) a else gcd(b,a % b)           //> gcd: (a: Integer, b: Integer)Integer
  
  gcd(14,21)                                      //> res0: Integer = 7
  
  
  def factorial(n:Integer): Integer =
  	if (n == 0) 1 else n*factorial(n-1)       //> factorial: (n: Integer)Integer
  	
  	
  def factorialTail(n: Int): Int = {
  	def loop(n: Int, expr: Int): Int =
  		if (n == 0) expr
  		else loop(n-1,n*expr)
  	
  	loop(n,1)
  }                                               //> factorialTail: (n: Int)Int
  
  factorial(4)                                    //> res1: Integer = 24
  
  factorialTail(5)                                //> res2: Int = 120
}