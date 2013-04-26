package week04

import List._;

object exercise {
  
  
  def nth[T](index: Int, list: List[T]): T = {
  	if (list.isEmpty) throw new IndexOutOfBoundsException();
  	else if(index == 0) list.head
  	else nth(index-1, list.tail)
  }                                               //> nth: [T](index: Int, list: week04.List[T])T
  
  
  val test = new Cons[Int](1,
  	new Cons[Int](2, new Nil[Int]))           //> test  : week04.Cons[Int] = week04.Cons@418c56d
  	
  test.head                                       //> res0: Int = 1
  test.tail                                       //> res1: week04.List[Int] = week04.Cons@76497934
  	
  	nth[Int](0,new Nil[Int]())                //> java.lang.IndexOutOfBoundsException
                                                  //| 	at week04.exercise$$anonfun$main$1.nth$1(week04.exercise.scala:9)
                                                  //| 	at week04.exercise$$anonfun$main$1.apply$mcV$sp(week04.exercise.scala:21
                                                  //| )
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at week04.exercise$.main(week04.exercise.scala:5)
                                                  //| 	at week04.exercise.main(week04.exercise.scala)
  	nth[Int](2,test)
}