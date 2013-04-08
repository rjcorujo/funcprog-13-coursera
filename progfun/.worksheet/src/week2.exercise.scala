package week2

object exercise {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(115); 
  
  def gcd(a: Integer, b: Integer): Integer =
  	if (b == 0) a else gcd(b,a % b);System.out.println("""gcd: (a: Integer, b: Integer)Integer""");$skip(16); val res$0 = 
  
  gcd(14,21);System.out.println("""res0: Integer = """ + $show(res$0));$skip(83); 
  
  
  def factorial(n:Integer): Integer =
  	if (n == 0) 1 else n*factorial(n-1);System.out.println("""factorial: (n: Integer)Integer""");$skip(151); 
  	
  	
  def factorialTail(n: Int): Int = {
  	def loop(n: Int, expr: Int): Int =
  		if (n == 0) expr
  		else loop(n-1,n*expr)
  	
  	loop(n,1)
  };System.out.println("""factorialTail: (n: Int)Int""");$skip(18); val res$1 = 
  
  factorial(4);System.out.println("""res1: Integer = """ + $show(res$1));$skip(22); val res$2 = 
  
  factorialTail(5);System.out.println("""res2: Int = """ + $show(res$2))}
}
