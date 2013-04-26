package week03

object intsets{
	val t1 = new NonEmpty(3, Empty, Empty)    //> t1  : week03.NonEmpty = {.3.}
	val t2 = t1 incl 4                        //> t2  : week03.IntSet = {.3{.4.}}
	t1                                        //> res0: week03.NonEmpty = {.3.}
	val t3 = new NonEmpty(5, Empty, Empty)    //> t3  : week03.NonEmpty = {.5.}
	t3                                        //> res1: week03.NonEmpty = {.5.}
	t2 union t3                               //> res2: week03.IntSet = {{{.3.}4.}5.}
}

abstract class IntSet {
	def incl(x : Int): IntSet
	def contains(x: Int): Boolean
	def union(other: IntSet): IntSet
}

//singleton
object Empty extends IntSet{
	def contains(x: Int): Boolean = false
	
	def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
	
	override def toString = "."
	
	def union(other: IntSet): IntSet = other
}



class NonEmpty(elem: Int, left: IntSet, right: IntSet)  extends IntSet {

	def contains(x: Int): Boolean =
		if (x < elem) left contains x
		else if (x > elem) right contains x
		else true

	def incl(x: Int): IntSet =
		if (x < elem) new NonEmpty(elem, left incl x, right)
		else if (x > elem) new NonEmpty(elem, left, right incl x)
		else this
	
	override def toString = "{" + left + elem + right + "}"
	
	def union(other: IntSet): IntSet =
		((left union right) union other) incl elem
}