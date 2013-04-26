package week03

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