package week06

import scala.io.Source

object phonenumbers {
  
  val words = List("abandoning","hyphen-test","abashed", "abductor") filter (word => word forall (chr => chr.isLetter))
                                                  //> words  : List[String] = List(abandoning, abashed, abductor)
  
  
  
  val mnem = Map(
  	'2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
  	'6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ"
  	)                                         //> mnem  : scala.collection.immutable.Map[Char,String] = Map(8 -> TUV, 4 -> GHI
                                                  //| , 9 -> WXYZ, 5 -> JKL, 6 -> MNO, 2 -> ABC, 7 -> PQRS, 3 -> DEF)
  	
  	
	val charCode = for {
  	(num,chars) <- mnem
  	char <- chars
  } yield (char,num)                              //> charCode  : scala.collection.immutable.Map[Char,Char] = Map(E -> 3, X -> 9, 
                                                  //| N -> 6, T -> 8, Y -> 9, J -> 5, U -> 8, F -> 3, A -> 2, M -> 6, I -> 4, G ->
                                                  //|  4, V -> 8, Q -> 7, L -> 5, B -> 2, P -> 7, C -> 2, H -> 4, W -> 9, K -> 5, 
                                                  //| R -> 7, O -> 6, D -> 3, Z -> 9, S -> 7)
			                                                  
	def wordCode(word: String): String = {
		word.toUpperCase map charCode
	}                                         //> wordCode: (word: String)String
  
  
 	val wordsForNum: Map[String, Seq[String]] =
 		words groupBy wordCode withDefaultValue Seq()
                                                  //> wordsForNum  : Map[String,Seq[String]] = Map(2227433 -> List(abashed), 22263
                                                  //| 66464 -> List(abandoning), 22382867 -> List(abductor))
  
  	
  	
  	
	def encode(number: String): Set[List[String]] = {
		if (number.isEmpty()) Set(List())
		else {
			for {
				split <- 1 to number.length
				word <- wordsForNum(number take split)
				rest <- encode(number drop split)
			} yield (word:: rest)
		}.toSet
	}                                         //> encode: (number: String)Set[List[String]]
	
	
	def translate(number: String): Set[String] = {
		encode(number) map (_ mkString " ")
	}                                         //> translate: (number: String)Set[String]
	
	encode("5282")                            //> res0: Set[List[String]] = Set()
	
 	wordCode("jAVA")                          //> res1: String = 5282
	//val charCode Map[Char,Char] = mnem.map{ case (key, value) => }
}