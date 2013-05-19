package week07

object test {
	var problem = new Pouring(Vector(4,9,11,13,24,32))
                                                  //> problem  : week07.Pouring = week07.Pouring@c75e4fc
	
	problem.moves                             //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with we
                                                  //| ek07.Pouring#Move] = Vector(Empty(0), Empty(1), Empty(2), Empty(3), Empty(4),
                                                  //|  Empty(5), Fill(0), Fill(1), Fill(2), Fill(3), Fill(4), Fill(5), Pour(0,1), P
                                                  //| our(0,2), Pour(0,3), Pour(0,4), Pour(0,5), Pour(1,0), Pour(1,2), Pour(1,3), P
                                                  //| our(1,4), Pour(1,5), Pour(2,0), Pour(2,1), Pour(2,3), Pour(2,4), Pour(2,5), P
                                                  //| our(3,0), Pour(3,1), Pour(3,2), Pour(3,4), Pour(3,5), Pour(4,0), Pour(4,1), P
                                                  //| our(4,2), Pour(4,3), Pour(4,5), Pour(5,0), Pour(5,1), Pour(5,2), Pour(5,3), P
                                                  //| our(5,4))
	
	problem.solutions(28)                     //> res1: scala.collection.immutable.Stream[week07.Pouring#Path] = Stream(Fill(5
                                                  //| ) Pour(5,0)--> Vector(4, 0, 0, 0, 0, 28), ?)
	
}