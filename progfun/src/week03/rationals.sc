package week03

object rationals {
  def rat = new Rational(1, 2)                    //> rat: => week03.Rational
  def rat2 = new Rational(1, 4)                   //> rat2: => week03.Rational
  rat.num                                         //> res0: Int = 1
  rat.den                                         //> res1: Int = 2

  rat + rat2                                      //> res2: week03.Rational = 3/4
  - rat2                                          //> res3: week03.Rational = 1/-4

  val x = new Rational(1, 2)                      //> x  : week03.Rational = 1/2
  val y = new Rational(5, 7)                      //> y  : week03.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : week03.Rational = 3/2

  (x - y) - z                                     //> res4: week03.Rational = 12/-7
  y + y                                           //> res5: week03.Rational = 10/7
  x < y                                           //> res6: Boolean = true
  x.max(y)                                        //> res7: week03.Rational = 5/7
  x + x                                           //> res8: week03.Rational = 1/1
  new Rational(4)                                 //> res9: week03.Rational = 4/1

  x + z                                           //> res10: week03.Rational = 2/1
  x + z                                           //> res11: week03.Rational = 2/1
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