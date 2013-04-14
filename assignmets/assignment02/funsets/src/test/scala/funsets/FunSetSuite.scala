package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {


  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  
  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }
  
  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   * 
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   * 
   *   val s1 = singletonSet(1)
   * 
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   * 
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   * 
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val sMulti = (x: Int) => x == 1 || x == 3 || x == 4 || x == 5 || x == 7 || x == 1000
    val set1To9 = (x: Int) => x > 0 && x < 10
    val set5To15 = (x: Int) => x > 4 && x < 16
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   * 
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {
    
    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3". 
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
      assert(!contains(s1, 3), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }
  
  test("intersection contains only elements in both sets") {
    new TestSets {
      val interSet = intersect(set1To9,set5To15)
      assert(!contains(interSet,1))
      assert(!contains(interSet,2))
      assert(!contains(interSet,3))
      assert(!contains(interSet,4))
      assert(contains(interSet,5),"Contains 5")
      assert(contains(interSet,6),"Contains 5")
      assert(contains(interSet,7),"Contains 5")
      assert(contains(interSet,8),"Contains 5")
      assert(contains(interSet,9),"Contains 5")
      assert(!contains(interSet,10))
      assert(!contains(interSet,11))
      assert(!contains(interSet,12))
      assert(!contains(interSet,13))
      assert(!contains(interSet,14))
      assert(!contains(interSet,15))
    }
  }
  
  test("for all") {
	  new TestSets {
		  assert(forall(s1,s1))
		  assert(forall(s1,(x: Int) => x < 5))
		  assert(!forall((x: Int) => x < 1000,(x: Int) => x < 5), "Not all elements makes the predicate true")
		  assert(forall((x: Int) => x < 3,(x: Int) => x < 5))
		  assert(!forall(sMulti, (x: Int) =>  x < 5 ), "Not all elements are not strictly less than 5")
	  }
  }
  
  test("exists") {
	  new TestSets {
		  assert(exists(s1,(x: Int) => x < 5), "Singleton includes < than 5")
		  assert(!exists(s1,(x: Int) => x > 5), "Singleton does not includes > than 5")
		  assert(exists(s1,(x: Int) => x == 1), "Singleton includes 1")
		  assert(!exists(s1,(x: Int) => x != 1), "Singleton excludes 1?")
	  }
  }
  
  test("map") {
	  new TestSets {
	    val mappedS1 = map(s1, (x :Int) => x +1)
	    val mappedS1Times2 = map(s1, (x :Int) => x*2)
	    assert(!contains(mappedS1,1))
	    assert(contains(mappedS1,2))
	    assert(!contains(mappedS1Times2,1))
	    assert(contains(mappedS1Times2,2))
	  }
  }
}
