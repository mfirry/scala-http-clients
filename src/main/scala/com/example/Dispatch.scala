package com.example
import dispatch._, Defaults._

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

// http://dispatch.databinder.net
object Dispatch {

  def main(args: Array[String]): Unit = {


    val header = Map("User-Agent" -> "Awesome-Octocat-App")
    val github = url("https://api.github.com/users/scala-italy") <:< header

    val x = Await.result(Http(github OK as.String), 1 second)
    println(x)
  }
}
