/* リスト 8.1 ここから */
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

val f1 = Future {
  Thread.sleep(5000)
  println("タスク1終了")
  1
}

val f2 = Future {
  Thread.sleep(1000)
  println("タスク2終了")
  2
}

for {
  res1 <- f1
  res2 <- f2
} {
  println(res1 + res2)
}

println("コード的には1番下だよ")
/* リスト 8.1 ここまで */



/* リスト 8.2 ここから */
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success, Failure}

val f1 = Future {
  Thread.sleep(1000)
  println("タスク1終了")
  4 / 2
}

val f2 = Future {
  Thread.sleep(3000)
  println("タスク2終了")
  2 / 0
}

val f = f1.zip(f2)
f.onComplete {
  case Success(res) => println(res._1 + res._2)
  case Failure(ex) => println(ex.getMessage)
}
/* リスト 8.2 ここまで */



/* リスト 8.3 ここから */
val list: List[Int] = List(1, 2, 3)

val f: (Int => Int) = x => x * 2

val mappedListF = list.map(f)
/* リスト 8.3 ここまで */



/* リスト 8.4 ここから */
val list: List[Int] = List(1, 2, 3)

val f: (Int => Int) = x => x * 2
val g: (Int => List[Int]) = x => List(x, x * 2)

val mappedListG = list.map(g)

val flatMappedList = list.flatMap(g)
/* リスト 8.4 ここまで */



/* リスト 8.5 ここから */
val res1 = for {
  i <- 1 to 2
  j <- 3 to 4
  k <- 5 to 6
} yield {
  i * j * k
}

val res2 =
  (1 to 2).flatMap(i =>
    (3 to 4).flatMap(j =>
      (5 to 6).map(k => i * j * k)))
/* リスト 8.5 ここまで */