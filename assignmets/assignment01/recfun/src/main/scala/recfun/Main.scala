package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (c == r || c == 0) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
      def skipNonParenthesis(chars: List[Char]): List[Char] =
        if (chars.isEmpty) chars
        else {
          if (chars.head == '(' || chars.head == ')') chars
          else skipNonParenthesis(chars.tail)
        }
      
      def updateCount(char: Char): Int =
        if (char == '(')
          1
        else if (char == ')') -1 else 0
        
      
      def checkPairs(chars: List[Char], acc: Int): Int = {
        val textChars: List[Char] = skipNonParenthesis(chars)
        if (acc < 0 || textChars.isEmpty) 
          acc
        else 
          checkPairs(textChars.tail, acc + updateCount(textChars.head))
      }
      
      checkPairs(chars,0) == 0
    		
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def canUseCoin(money: Int, coin: Int) = money - coin >= 0
    
    def countWithCoins(money: Int, coins: List[Int], acc: Int): Int = {
      if (coins.isEmpty) acc
      else if (money == 0) acc+1
      else {
		  if (canUseCoin(money,coins.head)) { 
    		val times = countWithCoins(money-coins.head, coins, acc);
		  	countWithCoins(money, coins.tail, times);
		  } else {
			  countWithCoins(money, coins.tail, acc);
		  }
      }
    }
    
    countWithCoins(money,coins,0)
  }
		  
  
  
}
