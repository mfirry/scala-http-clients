package com.example
import cats.effect._
import org.http4s._
import org.http4s.client.blaze.Http1Client
import org.http4s.client.dsl.Http4sClientDsl
import org.http4s.dsl.io._

// http://http4s.org/
object Http4s extends App with Http4sClientDsl[IO] {

    val h = Header("User-Agent", "Awesome-Octocat-App")
    val client = Http1Client[IO]()

    // there might be a better way to build a Task[Request]
    val req = GET(uri("https://api.github.com/users/scala-italy"))

    // we're blocking on purpose
    val responseBody = Http1Client[IO]().flatMap(_.expect[String](req))
    println(responseBody.unsafeRunSync())

}
