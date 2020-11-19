/* リスト 5.1 ここから */
abstract class Polygon(edges: List[Int]) {
  val n = edges.length
  val area: Double
}
/* リスト 5.1 ここまで */



/* リスト 5.2 ここから */
abstract class Polygon(edges: List[Int]) {
  val n = edges.length
  val area: Double
}

class Triangle(edges: List[Int]) extends Polygon(edges) {
  val a = edges(0)
  val b = edges(1)
  val c = edges(2)

  val area = {
    val s = (a + b + c) / 2.0
    math.sqrt(s * (s - a) * (s - b) * (s - c))
  }
}
/* リスト 5.2 ここまで */



/* リスト 5.4 ここから */
val edges = List(3, 4, 5)
val triangle = new Triangle(edges)
println(triangle.area)
/* リスト 5.4 ここまで */



/* リスト 5.5 ここから */
object Polygon {
  def fromEdges(edges: List[Int]): Polygon =
    edges.length match {
      case 3 =>
        new Triangle(edges)
      case x =>
        ???
    }
}

val edges3 = List(3, 4, 5)
val polygon3 = Polygon.fromEdges(edges3)
println(s"辺の数: ${polygon3.n}，面積: ${polygon3.area}")

val invalidEdges2 = List(3, 4)
/* リスト 5.5 ここまで */



/* リスト 5.6 ここから */
package example

object ScalaTour {
  def main(args: Array[String]): Unit = {
    val message = "Hello World"
    println(message)
  }
}
/* リスト 5.6 ここまで */



/* リスト 5.7 ここから */
sealed abstract class Animal(val cry: String)
object Cat extends Animal("にゃー")
object Dog extends Animal("わんわん")

def checkAnimal(animal: Animal): Unit = animal match {
  case Cat =>
    println(s"Catです．「${animal.cry}」と鳴きます")
  case Dog =>
    println(s"Dogです．「${animal.cry}」と鳴きます")
}

val cat = Cat
checkAnimal(cat)
/* リスト 5.7 ここまで */



/* リスト 5.8 ここから */
class Foo {
  def apply(): Unit =
    println("インスタンスメソッドのapplyです")
}
object Foo {
  def apply(str: String): Int = {
    println("クラスメソッドのapplyです")
    println(s"引数や返り値も自由にできます${str}")
    str.length
  }
}
val foo = new Foo
foo()
val result = Foo("!!!")
println(result)
/* リスト 5.8 ここまで */



/* リスト 5.9 ここから */
val generator = new scala.util.Random
case class Foo(i: Int) {
  val randomValue = generator.nextInt
}

val foo1 = Foo(10)

println(foo1.i)

println(foo1.toString)
println(foo1)

class Bar
val bar = new Bar
println(bar.toString)
println(bar)

val foo2 = foo1.copy()
println(s"${foo1}，randomValue: ${foo1.randomValue}")
println(s"${foo2}，randomValue: ${foo2.randomValue}")

foo1 match {
  case Foo(i) => println(s"Fooであり，iは${i}です")
  case _ => println("Fooではありません")
}
/* リスト 5.9 ここまで */



/* リスト 5.10 ここから */
sealed abstract class Animal(val cry: String)
case object Cat extends Animal("にゃー")
case object Dog extends Animal("わんわん")

def checkAnimal(animal: Animal): Unit = {
  println(s"${animal}です．「${animal.cry}」と鳴きます")
}

val cat = Cat
checkAnimal(cat)
/* リスト 5.10 ここまで */



/* リスト 5.11 ここから */
abstract class Polygon(edges: List[Int]) {
  val n = edges.length
  val area: Double
}

trait Color {
  val red: Int
  val green: Int
  val blue: Int

  def printColor(): Unit = println(s"$red-$green-$blue")
}
trait Blue extends Color {
  override val red = 0
  override val green = 0
  override val blue = 255
}
trait Yellow extends Color {
  override val red = 255
  override val green = 255
  override val blue = 0
}

trait Transparency {
  val alpha: Double
}
trait Frosted extends Transparency {
  override val alpha = 0.5
}

class BlueFrostedTriangle(edges: List[Int])
    extends Polygon(edges) with Blue with Frosted {
  val a = edges(0)
  val b = edges(1)
  val c = edges(2)

  val area = {
    val s = (a + b + c) / 2.0
    math.sqrt(s * (s - a) * (s - b) * (s - c))
  }
}

val edges = List(3, 4, 5)
val blueFrostedTriangle = new BlueFrostedTriangle(edges)
blueFrostedTriangle.printColor()
println(blueFrostedTriangle.alpha)
/* リスト 5.11 ここまで */



/* リスト 5.12 ここから */
class Triangle(edges: List[Int]) extends Polygon(edges) {
  val a = edges(0)
  val b = edges(1)
  val c = edges(2)

  val area = {
    val s = (a + b + c) / 2.0
    math.sqrt(s * (s - a) * (s - b) * (s - c))
  }
}

val edges = List(3, 4, 5)
val blueFrostedTriangle = new Triangle(edges) with Blue with Frosted
blueFrostedTriangle.printColor()
println(blueFrostedTriangle.alpha)
/* リスト 5.12 ここまで */



/* リスト 5.14 ここから */
val tuple21 = (1, "Hello")

val tuple22 = 1 -> "Hello"

val tuple3 = (1, "Hello", List(1, 2, 3))

println(tuple21._1)
println(tuple21._2)
/* リスト 5.14 ここまで */



/* リスト 5.15 ここから */
def popHead(xs: List[Int]): (Int, List[Int]) = xs.head -> xs.tail

val list = List(1, 2, 3)

val headTail = popHead(list)
val head = headTail._1
val tail = headTail._2

val (h, t) = popHead(list)
/* リスト 5.15 ここまで */
