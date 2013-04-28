package week04

object natural_class {
	val num3 = new Succ(new Succ(new Succ(Zero)))
                                                  //> num3  : week04.Succ = Succ(Succ(Succ(Zero)))
	val num2 = new Succ(new Succ(Zero))       //> num2  : week04.Succ = Succ(Succ(Zero))
	val zero = Zero                           //> zero  : week04.Zero.type = Zero
	
	zero + num3                               //> res0: week04.Nat = Succ(Succ(Succ(Zero)))

	num3 - zero                               //> res1: week04.Nat = Succ(Succ(Succ(Zero)))
	
	num2 + num3                               //> res2: week04.Nat = Succ(Succ(Succ(Succ(Succ(Zero)))))
	
	num3 - num2                               //> res3: week04.Nat = Succ(Zero)

}

abstract class Nat {
	def isZero: Boolean
	def predecessor: Nat
	def succesor = new Succ(this)
	
	def + (that: Nat): Nat
	def - (that: Nat): Nat
}

class Succ(n: Nat) extends Nat {
	
	def isZero = false

	def predecessor = n
	
	def + (that: Nat) = {
		if (that.isZero) this
		else succesor + that.predecessor
	}
	
	def - (that: Nat) = {
		if (that.isZero) this
		else predecessor - that.predecessor
	}
	
	override def toString = "Succ("+n+")"
}

object Zero extends Nat {
	def isZero = true
	def predecessor = throw new IllegalAccessException("Zero Has no predecessor")
	
	def + (that: Nat) = that
	def - (that: Nat) = if(that.isZero) this else throw new IllegalStateException("Zero Can not be substracted")
	override def toString = "Zero"
}