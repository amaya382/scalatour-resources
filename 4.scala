/* リスト 4.2 ここから */
val n = 3
for { i <- (1 to n) }{
  println(i)
}
/* リスト 4.2 ここまで */



/* リスト 4.4 ここから */
for {
  i <- (0 to 12 by 3) if i % 2 == 0
  j <- (1 to 3)
} {
  println(i * j)
}
/* リスト 4.4 ここまで */



/* リスト 4.6 ここから */
val result = for {
  i <- (1 to 3)
} {
  i
}
/* リスト 4.6 ここまで */



/* リスト 4.7 ここから */
def fizzBuzz(n: Int): Unit = for { i <- 1 to n } {
  if (i % 15 == 0) {
    println("FizzBuzz")
  } else if (i % 3 == 0) {
    println("Fizz")
  } else if (i % 5 == 0) {
    println("Buzz")
  } else {
    println(i)
  }
}
/* リスト 4.7 ここまで */



/* リスト 4.10 ここから */
def fizzBuzz(n: Int): Unit = for { i <- 1 to n } {
  i match {
    case x if x % 15 == 0 =>
      println("FizzBuzz")
    case x if x % 3 == 0 =>
      println("Fizz")
    case x if x % 5 == 0 =>
      println("Buzz")
    case x =>
      println(x)
  }
}
/* リスト 4.10 ここまで */



/* リスト 4.13 ここから */
val data = 10
val result = data match {
  case 0 =>
    "0です"

  case 1 | 2 =>
    "1か2です"

  case x if x % 3 == 0 =>
    "0でも1でも2でもなく3で割り切れる値である" + x.toString + "です"

  case x =>
    s"0でも1でも2でもなく3で割り切れない値である${x}です"
}

println(result)
/* リスト 4.13 ここまで */



/* リスト 4.14 ここから */
def fizzBuzz(n: Int, i: Int = 1): Unit = {
  i match {
    case x if x % 15 == 0 =>
      println("FizzBuzz")
    case x if x % 3 == 0 =>
      println("Fizz")
    case x if x % 5 == 0 =>
      println("Buzz")
    case x =>
      println(x)
  }

  if (i < n) fizzBuzz(n, i + 1)
}

fizzBuzz(15) 
/* リスト 4.14 ここまで */



/* リスト 4.15 ここから */
def fib(n: Int): Int =
  if (n < 2) n else fib(n - 1) + fib(n - 2)
/* リスト 4.15 ここまで */



/* リスト 4.16 ここから */
def fib(n: Int): Int = {
  @scala.annotation.tailrec
  def go(n: Int, prev: Int, curr: Int): Int =
    if(n == 0) prev
    else go(n - 1, curr, prev + curr)
  go(n, 0, 1)
}
/* リスト 4.16 ここまで */