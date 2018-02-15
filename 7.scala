/* リスト 7.1 ここから */
val invalidEdges2 = List(3, 4)

val invalidEdges3 = List(3, 4, 100)
/* リスト 7.1 ここまで */



/* リスト 7.2 ここから */
object Polygon {
  def fromEdges(edges: List[Int]): Polygon =
    edges.length match {
      case 3 =>
        new Triangle(edges)
      case x =>
        null
    }
}

val invalidEdges2 = List(3, 4)
val invalidPolygon2 = Polygon.fromEdges(invalidEdges2)
/* リスト 7.2 ここまで */



/* リスト 7.3 ここから */
object Polygon {
  def fromEdges(edges: List[Int]): Option[Polygon] =
    edges.length match {
      case 3 =>
        Some(new Triangle(edges))
      case x =>
        None
    }
}

val edges3 = List(3, 4, 5)
val polygon3 = Polygon.fromEdges(edges3)
polygon3 match {
  case Some(p) => println(p.area)
  case None =>
    println("不正な辺が与えられたため面積は出力できません")
}

polygon3.foreach(p => println(p.area))
polygon3
  .map(p => p.area * 2)
  .foreach(area => println(area))

val invalidEdges2 = List(3, 4)
val invalidPolygon2 = Polygon.fromEdges(invalidEdges2)
invalidPolygon2 match {
  case Some(p) => println(p.area)
  case None =>
    println("不正な辺が与えられたため面積は出力できません")
}

invalidPolygon2.foreach(p => println(p.area))
invalidPolygon2
  .map(p => p.area * 2)
  .foreach(area => println(area))
/* リスト 7.3 ここまで */



/* リスト 7.4 ここから */
val map1 = Map((1, "A"), (2, "B"))
val value1 = map1.get(1)
val value2 = map1.get(100)

val list1 = List(1, 2, 3, 4)
val found1 = list1.find(i => i % 2 == 0)
val found2 = list1.find(i => i % 5 == 0)
/* リスト 7.4 ここまで */



/* リスト 7.5 ここから */
object Polygon {
  def fromEdges(edges: List[Int]): Option[Polygon] =
    edges.length match {
      case 3 => Triangle.fromEdges(edges)
      case x => None
    }
}

class Triangle private (edges: List[Int]) extends Polygon(edges) {
  val a = edges(0)
  val b = edges(1)
  val c = edges(2)

  val area = {
    val s = (a + b + c) / 2.0
    math.sqrt(s * (s - a) * (s - b) * (s - c))
  }
}

object Triangle {
  def fromEdges(edges: List[Int]): Option[Triangle] =
    if(edges.length == 3
        && edges(0) + edges(1) > edges(2)
        && edges(1) + edges(2) > edges(0)
        && edges(2) + edges(0) > edges(1))
      Some(new Triangle(edges))
    else None
}

val edges3 = List(3, 4, 5)
val polygon3 = Polygon.fromEdges(edges3)
polygon3 match {
  case Some(polygon) => println(polygon.area)
  case None =>
    println("不正な数の辺か図形が成立しない辺が与えられたため面積は出力できません")
}

val invalidEdges3 = List(3, 4, 100)
val invalidPolygon3 = Polygon.fromEdges(invalidEdges3)
invalidPolygon3 match {
  case Some(polygon) => println(polygon.area)
  case None =>
    println("不正な数の辺か図形が成立しない辺が与えられたため面積は出力できません")
}

val invalidEdges2 = List(3, 4)
val invalidPolygon2 = Polygon.fromEdges(invalidEdges2)
invalidPolygon2 match {
  case Some(polygon) => println(polygon.area)
  case None => println("不正な数の辺か図形が成立しない辺が与えられたため面積は出力できません")
}
/* リスト 7.5 ここまで */



/* リスト 7.6 ここから */
object Polygon {
  def fromEdges(edges: List[Int]): Either[String, Polygon] =
    edges.length match {
      case 3 => Triangle.fromEdges(edges)
      case x => Left(s"${x}個の辺から成る多角形は実装されていません")
    }
}

object Triangle {
  def fromEdges(edges: List[Int]): Either[String, Triangle] =
    if(edges.length != 3)
      Left(s"${edges.length}個の辺から三角形は作成できません")
    else if(!(edges(0) + edges(1) > edges(2)
        && edges(1) + edges(2) > edges(0)
        && edges(2) + edges(0) > edges(1)))
      Left("三角形が成立しない辺の組合せです")
    else Right(new Triangle(edges))
}

val edges3 = List(3, 4, 5)
val polygon3 = Polygon.fromEdges(edges3)
polygon3 match {
  case Right(p) => println(p.area)
  case Left(err) => println(err)
}

polygon3.foreach(p => println(p.area))
polygon3
  .map(p => p.area * 2)
  .foreach(area => println(area))

val invalidEdges3 = List(3, 4, 100)
val invalidPolygon3 = Polygon.fromEdges(invalidEdges3)
invalidPolygon3 match {
  case Right(p) => println(p.area)
  case Left(err) => println(err)
}

invalidPolygon3.foreach(p => println(p.area))

val invalidEdges2 = List(3, 4)
val invalidPolygon2 = Polygon.fromEdges(invalidEdges2)
invalidPolygon2 match {
  case Right(p) => println(p.area)
  case Left(err) => println(err)
}

invalidPolygon2.foreach(p => println(p.area))
/* リスト 7.6 ここまで */



/* リスト 7.7 ここから */
def divid(x: Int, y: Int): Int = x / y
def sthNotImplemented(x: Int): Int = ???

val msg1 = try {
    "Hello" + " " + "World"
  } catch {
    case e: java.lang.ArithmeticException =>
      s"Invalid arithmetics (${e.getMessage})"
    case e: Throwable =>
      "Unknown error"
  } finally { println("completed") }

try {
  println(divid(10, 0))
} catch {
  case e: java.lang.ArithmeticException =>
    println(s"Invalid arithmetics (${e.getMessage})")
  case e: Throwable =>
    println("Unknown error")
}

try {
  println(sthNotImplemented(10))
} catch {
  case e: java.lang.ArithmeticException =>
    println(s"Invalid arithmetics (${e.getMessage})")
  case e: Throwable =>
    println("Unknown error")
} finally { println("completed") }
/* リスト 7.7 ここまで */