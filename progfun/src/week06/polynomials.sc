package week06

object polynomials {

	class Poly(val terms0: Map[Int,Double]) {
	
		def this(bindings: (Int,Double)*) = this(bindings.toMap)
		
		val terms = terms0.withDefaultValue(0.0)
		
		
		def addTerm(terms: Map[Int,Double], term: (Int,Double)) = {
			val (exp,coef) = term
			terms + (exp -> (coef + terms(exp)))
		}
		
		def + (other: Poly) = {
			new Poly((other.terms foldLeft terms)(addTerm))
		}
		
		override def toString =
			(for ((exp,coef) <- terms.toList.sorted.reverse) yield coef+"x^"+exp) mkString " + "
	}
	
	val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2)
                                                  //> p1  : week06.polynomials.Poly = 6.2x^5 + 4.0x^3 + 2.0x^1
	val p2 = new Poly(Map(0 -> 3.2, 3 -> 7.0))//> p2  : week06.polynomials.Poly = 7.0x^3 + 3.2x^0
	
	p1 + p2                                   //> res0: week06.polynomials.Poly = 6.2x^5 + 11.0x^3 + 2.0x^1 + 3.2x^0
}