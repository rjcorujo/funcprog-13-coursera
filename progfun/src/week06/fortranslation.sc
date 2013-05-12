package week06

object fortranslation {

	class Book(val title:String, val authors:List[String]) {
		override def toString() = this.title+"("+this.authors+")"
	}

	val books = Set(
		new Book("title1",List("author1")),
		new Book("title2",List("author2"))
		)                                 //> books  : scala.collection.immutable.Set[week06.fortranslation.Book] = Set(ti
                                                  //| tle1(List(author1)), title2(List(author2)))
		
	for {
		b <- books
		a <- b.authors
		if (a.startsWith("author1"))
		} yield b.title                   //> res0: scala.collection.immutable.Set[String] = Set(title1)
		
		
		
	books.flatMap(b =>
			b.authors.withFilter(a => a.startsWith("author1"))
			.map(y => b)
	).map(b=> b.title)                        //> res1: scala.collection.immutable.Set[String] = Set(title1)
}