package hammock

import cats._
import cats.implicits._
import scala.util.{ Failure, Success, Try }
import io.circe._
import io.circe.generic.auto._
import hammock._
import hammock.jvm.free.Interpreter
import hammock.circe.implicits._

object hammockClient extends App {
  implicit val interpreter = Interpreter()

  val response: Try[HttpResponse] = Hammock
    .request(Method.GET, "https://api.github.com/users/scala-italy", Map("User-Agent" -> "Awesome-Octocat-App"))
    .exec[Try]

   response match {
     case Failure(e) => println(e)
     case Success(res) => println(res.content)
   }
}