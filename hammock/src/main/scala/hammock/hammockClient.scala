package hammock

import cats.effect.IO

import cats.effect.IO
import io.circe.generic.auto._
import hammock._
import hammock.marshalling._
import hammock.jvm.Interpreter
import hammock.circe.implicits._

object hammockClient extends App {
  implicit val interpreter = Interpreter[IO]

  val response = Hammock
    .request(Method.GET, uri"https://api.github.com/users/scala-italy", Map("User-Agent" -> "Awesome-Octocat-App"))
    .exec[IO]

}