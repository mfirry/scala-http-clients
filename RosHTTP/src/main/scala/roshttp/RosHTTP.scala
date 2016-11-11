package com.example

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import fr.hmil.roshttp.HttpRequest

//https://github.com/hmil/RosHTTP
object RosHTTP {
  def main(args: Array[String]): Unit = {

    val request = HttpRequest("https://api.github.com/users/scala-italy")
      .withHeader("User-Agent", "Awesome-Octocat-App")
      .send()
      .map(response => println(response.body))

    Await.result(request, 1 second)
  }
}
