/* リスト 6.1 ここから */
class Box[T](var element: T) {
  def get(): T = element
  def set(newElement: T): Unit = {
    element = newElement
  }
}

val intBox = new Box[Int](10)
println(intBox.get())
intBox.set(0)
println(intBox.get())

sealed abstract class Animal(val cry: String)
case object Cat extends Animal("にゃー")
case object Dog extends Animal("わんわん")

val animalBox = new Box[Animal](Cat)
println(animalBox.get())
animalBox.set(Dog)
println(animalBox.get())

val intBox2 = new Box(10)
val catBox = new Box(Cat)
/* リスト 6.1 ここまで */



/* リスト 6.3 ここから */
def toFizzBuzz(numbers: List[Int]): List[String] =
  numbers.map((i: Int) => i match {
    case x if x % 15 == 0 => "FizzBuzz"
    case x if x % 3 == 0 => "Fizz"
    case x if x % 5 == 0 => "Buzz"
    case x => x.toString
  })

val n = 15
val numbers = (1 to n).toList
val fizzBuzzList = toFizzBuzz(numbers)
fizzBuzzList.foreach((s: String) => println(s))
/* リスト 6.3 ここまで */



/* リスト 6.4 ここから */
def toFizzBuzz(numbers: List[Int]): List[String] = {
  val f: Int => String = (i: Int) => i match {
    case x if x % 15 == 0 => "FizzBuzz"
    case x if x % 3 == 0 => "Fizz"
    case x if x % 5 == 0 => "Buzz"
    case x => x.toString
  }
  numbers.map(f)
}
/* リスト 6.4 ここまで */



/* リスト 6.5 ここから */
val string = "Hello"

string.foreach(c => println(c))
/* リスト 6.5 ここまで */



/* リスト 6.6 ここから */
val oneToThree = 1 to 3

val oneUntilThree = 1 until 3

val threeToOne = 3 to 1 by -1

val oneToThree0 = 1.to(3)
/* リスト 6.6 ここまで */



/* リスト 6.7 ここから */
val arr1 = Array.fill(5)(0)

val arr2 = Array("Hello", "World")

for { i <- 0 to 1 } { println(arr2(i)) }

arr2.foreach(el => println(el))

arr2(0) = "Hell"
arr2.foreach(el => println(el))
/* リスト 6.7 ここまで */



/* リスト 6.8 ここから */
val list1 = List.fill(5)(0)

val list2 = List("Hello", "World")

list2.foreach(el => println(el))

var list3 = List("Hello", "World")
list3 = List("Hell", "World")

val list4 = 1 :: 2 :: 3 :: Nil

val list5 = 0 :: list4

def threeTimesThree(list: List[Int]): List[Int] =
  list match {
    case head :: tail if head % 3 == 0 =>
      (head * 3) :: threeTimesThree(tail)
    case head :: tail =>
      head :: threeTimesThree(tail)
    case Nil => Nil
  }
threeTimesThree(list5)
/* リスト 6.8 ここまで */



/* リスト 6.9 ここから */
val set1 = Set(0, 0, 0)

set1.foreach(el => println(el))
println(set1.size)

val list = List(0, 0, 1, 1)
println(list.size)

val set2 = list.toSet
println(set2.size)
/* リスト 6.9 ここまで */



/* リスト 6.10 ここから */
val map1 = Map((1, "A"), (2, "B"))

val value1 = map1.get(1)
val value2 = map1.get(100)

val list1: List[(Int, String)] =
  List((1, "A"), (2, "B"))
val map2 = list1.toMap

val list2 = List(1, 2)
val map3 = list2.map(i => (i, i.toString)).toMap
/* リスト 6.10 ここまで */



/* リスト 6.11 ここから */
val list1 = List(1,2, 3)
val list2 = list1.map(i => s"No．${i}")
/* リスト 6.11 ここまで */



/* リスト 6.12 ここから */
val list1 = List(1, 2, 3)
list1.foreach(i => println(i))
/* リスト 6.12 ここまで */



/* リスト 6.13 ここから */
val list = List("a", "b", "c")
list.zipWithIndex
  .foreach(pair => println(s"インデックス: ${pair._2}, 要素: ${pair._1}"))
/* リスト 6.13 ここまで */



/* リスト 6.14 ここから */
val list1 = List(1, 2, 3, 4)
val list2 = list1.filter(i => i % 2 == 0)
/* リスト 6.14 ここまで */



/* リスト 6.15 ここから */
val list = List(1,2, 3, 4)
println(list.count(i => i % 2 == 0))
/* リスト 6.15 ここまで */



/* リスト 6.16 ここから */
val list1 = List(1, 2, 3)
println(list1.contains(1))
println(list1.contains(999))
/* リスト 6.16 ここまで */



/* リスト 6.17 ここから */
val list1 = List(1, 2, 3)
val list2 = List(5, 6, 7)
val list3 = list1 ++ list2
val list4 = list2 ++ list1
/* リスト 6.17 ここまで */



/* リスト 6.18 ここから */
val list1 = List(1, 2, 3)
println(list1.mkString)
println(list1.mkString(","))
println(list1.mkString("[", ",", "]"))
/* リスト 6.18 ここまで */