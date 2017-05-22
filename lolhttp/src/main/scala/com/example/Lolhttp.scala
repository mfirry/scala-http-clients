package com.example

import lol.http._

import scala.concurrent._
import ExecutionContext.Implicits.global

object Lolhttp extends App {

  val githubClient = Client("api.github.com", 443, "https")
  val request = Get("/users/scala-italy").addHeaders(h"User-Agent" -> h"Awesome-Octocat-App")

  // githubClient.run(request)(_.readSuccessAs[String]).foreach(println)

}
