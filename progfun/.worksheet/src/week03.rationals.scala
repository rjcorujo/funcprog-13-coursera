package week03

object rationals {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(65); 
  def rat = new Rational(1, 2);System.out.println("""rat: => week03.Rational""");$skip(32); 
  def rat2 = new Rational(1, 4);System.out.println("""rat2: => week03.Rational""");$skip(10); val res$0 = 
  rat.num;System.out.println("""res0: Int = """ + $show(res$0));$skip(10); val res$1 = 
  rat.den;System.out.println("""res1: Int = """ + $show(res$1));$skip(14); val res$2 = 

  rat + rat2;System.out.println("""res2: week03.Rational = """ + $show(res$2));$skip(9); val res$3 = 
  - rat2;System.out.println("""res3: week03.Rational = """ + $show(res$3));$skip(30); 

  val x = new Rational(1, 2);System.out.println("""x  : week03.Rational = """ + $show(x ));$skip(29); 
  val y = new Rational(5, 7);System.out.println("""y  : week03.Rational = """ + $show(y ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : week03.Rational = """ + $show(z ));$skip(15); val res$4 = 

  (x - y) - z;System.out.println("""res4: week03.Rational = """ + $show(res$4));$skip(8); val res$5 = 
  y + y;System.out.println("""res5: week03.Rational = """ + $show(res$5));$skip(8); val res$6 = 
  x < y;System.out.println("""res6: Boolean = """ + $show(res$6));$skip(11); val res$7 = 
  x.max(y);System.out.println("""res7: week03.Rational = """ + $show(res$7));$skip(8); val res$8 = 
  x + x;System.out.println("""res8: week03.Rational = """ + $show(res$8));$skip(18); val res$9 = 
  new Rational(4);System.out.println("""res9: week03.Rational = """ + $show(res$9));$skip(9); val res$10 = 

  x + z;System.out.println("""res10: week03.Rational = """ + $show(res$10));$skip(8); val res$11 = 
  x + z;System.out.println("""res11: week03.Rational = """ + $show(res$11))}
}

class Rational(x: Int, y: Int) {

  //A automatic primary constructor will execute the whole body of the class

  require(y != 0, "Denominator must be nonzero") //throws an illegalargument exception if condition is false

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  private val g = gcd(x, y)
  def num = x / g
  def den = y / g

  def this(x: Int) = this(x, 1)

  def < (that: Rational) = num * that.den < that.num * den

  def max(that: Rational) = if (this < that) that else this

  def + (that: Rational) =
    new Rational(num * that.den + that.num * den, den * that.den)


  override def toString =
    num + "/" + den

  def unary_- = new Rational(-num, den)

  def -(that: Rational) = this + (-that)

}
