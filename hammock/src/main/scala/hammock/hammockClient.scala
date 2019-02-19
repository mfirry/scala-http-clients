package hammock

import cats.effect.IO

import cats.effect.IO
import io.circe.generic.auto._
import hammock._
import hammock.marshalling._
import hammock.apache.ApacheInterpreter
import hammock.circe.implicits._

object hammockClient extends App {
  implicit val interpreter = ApacheInterpreter[IO]

  val response = Hammock
    .request(Method.GET, uri"https://api.github.com/users/scala-italy", Map("User-Agent" -> "Awesome-Octocat-App"))
    .exec[IO]
    .unsafeRunSync

    println(response)

}