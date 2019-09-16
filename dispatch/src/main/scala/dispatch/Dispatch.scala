package com.example

import scala.language.postfixOps

import dispatch._, Defaults._

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

// https://dispatchhttp.org
object Dispatch {

  def main(args: Array[String]): Unit = {

    val header = Map("User-Agent" -> "Awesome-Octocat-App")
    val github = url("https://api.github.com/users/scala-italy") appendHeaders header

    val x = Await.result(Http.default(github OK as.String), 1 second)
    println(x)
  }
}
