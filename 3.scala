/* リスト 3.1 ここから */
package example

object ScalaTour {
  def main(args: Array[String]): Unit = {
    val message = "Hello World"
    println(message)
  }
}
/* リスト 3.1 ここまで */



/* リスト 3.2 ここから */
package example

object ScalaTour extends App {
  val message = "Hello World"
  println(message)
}
/* リスト 3.2 ここまで */



/* リスト 3.3 ここから */
val message = "Hello World"
/* リスト 3.3 ここまで */



/* リスト 3.5 ここから */
val message: String = "Hello World"
/* リスト 3.5 ここまで */



/* リスト 3.6 ここから */
var mutableMessage = "Hello World"
mutableMessage = "Changed World"
/* リスト 3.6 ここまで */



/* リスト 3.8 ここから */
{
  println("Hello World")
}
/* リスト 3.8 ここまで */



/* リスト 3.9 ここから */
val result = {
  val x = 1 + 2
  x * 2
}
/* リスト 3.9 ここまで */



/* リスト 3.10 ここから */
def add(x: Int，y: Int): Int = x + y
/* リスト 3.10 ここまで */



/* リスト 3.11 ここから */
def add(x: Int，y: Int): Int = x + y
/* リスト 3.11 ここまで */



/* リスト 3.12 ここから */
def identity(x: Int): Int = x
/* リスト 3.12 ここまで */



/* リスト 3.13 ここから */
class Foo {
  def bar(x: Int): Int = {
    if (x % 2 == 0) x * 2
    else ???
  }

  def baz(s: String): String = ???
}
/* リスト 3.13 ここまで */