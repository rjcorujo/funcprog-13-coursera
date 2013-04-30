package week01

import scala.annotation.tailrec

object session {

	def abs(x: Double) = if (x < 0) -x else x //> abs: (x: Double)Double

  
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
  }                                               //> sqrt: (x: Double)Double
  
  sqrt(4)                                         //> res0: Double = 2.000609756097561
  sqrt(9)                                         //> res1: Double = 3.00009155413138
  sqrt(1e-6)                                      //> res2: Double = 0.0010000001533016628
  sqrt(1e60)                                      //> res3: Double = 1.0000788456669446E30
  
  //tests
  sqrt(0.001)                                     //> res4: Double = 0.03162278245070105
  sqrt(0.1e-20)                                   //> res5: Double = 3.1633394544890125E-11
  sqrt(1e20)                                      //> res6: Double = 1.0000021484861237E10
  sqrt(1e50)                                      //> res7: Double = 1.0000003807575104E25

  
  
}