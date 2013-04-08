package week01

import scala.annotation.tailrec

object session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(109); 

	def abs(x: Double) = if (x < 0) -x else x;System.out.println("""abs: (x: Double)Double""");$skip(421); 

  
  def sqrt(x: Double) = { //using a block to avoid name polluting, this functions are not
  
	  def isGoodEnough(guess: Double) =
	  	//abs(guess*guess - x) < 0.00001*x
	  	abs(1 - (guess*guess)/x) < 0.001
	  
	  def improve(guess: Double) =
	  	(guess + x/guess)/2
	  
	  def sqrtIter(guess: Double): Double =
	  	if (isGoodEnough(guess))
	  		guess
	  	else
	  		sqrtIter(improve(guess))
	  		
  	sqrtIter(1.0)
  };System.out.println("""sqrt: (x: Double)Double""");$skip(13); val res$0 = 
  
  sqrt(4);System.out.println("""res0: Double = """ + $show(res$0));$skip(10); val res$1 = 
  sqrt(9);System.out.println("""res1: Double = """ + $show(res$1));$skip(13); val res$2 = 
  sqrt(1e-6);System.out.println("""res2: Double = """ + $show(res$2));$skip(13); val res$3 = 
  sqrt(1e60);System.out.println("""res3: Double = """ + $show(res$3));$skip(27); val res$4 = 
  
  //tests
  sqrt(0.001);System.out.println("""res4: Double = """ + $show(res$4));$skip(16); val res$5 = 
  sqrt(0.1e-20);System.out.println("""res5: Double = """ + $show(res$5));$skip(13); val res$6 = 
  sqrt(1e20);System.out.println("""res6: Double = """ + $show(res$6));$skip(13); val res$7 = 
  sqrt(1e50);System.out.println("""res7: Double = """ + $show(res$7))}
 
  
  
}
