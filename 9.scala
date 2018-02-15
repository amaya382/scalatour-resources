/* リスト 9.1 ここから */
libraryDependencies ++= Seq(
  "org.json4s" %% "json4s-jackson" % "3.5.3",
  "org.scala-sbt" %% "io" % "1.1.0",
  "org.scalatest" %% "scalatest" % "3.0.5" % Test)
/* リスト 9.1 ここまで */



/* リスト 9.2 ここから */
package example

import sbt.io.IO
import java.io.File
import org.json4s._
import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._
import org.json4s.jackson.Serialization.{read, write}

object ScalaTour {
  implicit val formats = org.json4s.DefaultFormats

  def main(args: Array[String]): Unit = {
    val sourceFile = new File("sample.json")
    val destinationFile = new File("fizzBuzz.json")

    createSourceJSON(15, sourceFile)

    fizzBuzzFromJSON(sourceFile, destinationFile)
  }

  def createSourceJSON(n: Int, srcFile: File): Unit = {
    require(n >= 1)

    val intArrayHolder = IntArrayHolder((1 to n).toArray)
    IO.write(srcFile, write(intArrayHolder))
  }

  def fizzBuzzFromJSON(srcFile: File, dstFile: File): Unit = {
    val rawJson = IO.read(srcFile)
    val intArrayHolder = read[IntArrayHolder](rawJson)

    val fizzBuzz = intArrayHolder.intArray.map(i =>
      i match {
        case x if x % 15 == 0 => "FizzBuzz"
        case x if x % 3 == 0  => "Fizz"
        case x if x % 5 == 0  => "Buzz"
        case x                => x.toString
    })
    val fizzBuzzHolder = FizzBuzzHolder(fizzBuzz)

    IO.write(dstFile, write(fizzBuzzHolder))
  }
}

case class IntArrayHolder(intArray: Array[Int])
case class FizzBuzzHolder(fizzBuzz: Array[String])
/* リスト 9.2 ここまで */



/* リスト 9.3 ここから */
val language = "Scala"
val jsonString = s"""{
  "language": "${language}",
  "extension": ".${language.toLowerCase}"
}"""
println(jsonString)
/* リスト 9.3 ここまで */



/* リスト 9.6 ここから */
object Outer {
  implicit class MyString(val str: String) extends AnyVal {
    def addPeriod(): String =
      if (str.endsWith(".")) str else str + "."
  }

  println("Hello World".addPeriod)
  println("I am a pen.".addPeriod)
}
Outer
/* リスト 9.6 ここまで */



/* リスト 9.8 ここから */
package example

import org.scalatest._
import sbt.io.IO
import java.io.File
import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._
import org.json4s.jackson.Serialization.{read, write}

class ScalaTourSpec extends FlatSpec {
  def createSourceJSONAndThenFizzBuzzFromJSON(n: Int): Unit = {
    implicit val formats = org.json4s.DefaultFormats
    val sourceFile = new File("sample.json")
    val destinationFile = new File("fizzBuzz.json")

    ScalaTour.createSourceJSON(n, sourceFile)
    ScalaTour.fizzBuzzFromJSON(sourceFile, destinationFile)

    val json = read[FizzBuzzHolder](IO.read(destinationFile))
    json.fizzBuzz.zipWithIndex.foreach(pair => {
      pair._2 + 1 match {
        case x if x % 15 == 0 => assert(pair._1 === "FizzBuzz")
        case x if x % 3 == 0  => assert(pair._1 === "Fizz")
        case x if x % 5 == 0  => assert(pair._1 === "Buzz")
        case x                => assert(pair._1 === x.toString)
      }
    })
  }

  s"`createSourceJSON` and `fizzBuzzFromJSON` (1 to 0)" should
    "throw IllegalArgumentException" in {
    assertThrows[IllegalArgumentException] {
      createSourceJSONAndThenFizzBuzzFromJSON(0)
    }
  }
  for { n <- Array(1, 15, 100) } {
    s"`createSourceJSON` and `fizzBuzzFromJSON` (1 to $n)" should
      "apply FizzBuzz to data from JSON file" in {
      createSourceJSONAndThenFizzBuzzFromJSON(n)
    }
  }
  s"`createSourceJSON` and `fizzBuzzFromJSON` (1 to 0)" should
    "apply FizzBuzz to data from JSON file" in {
    createSourceJSONAndThenFizzBuzzFromJSON(0)
  }
}
/* リスト 9.8 ここまで */