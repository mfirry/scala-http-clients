package com.example
import scala.concurrent._
import scala.concurrent.duration._
import gigahorse.Gigahorse

// https://github.com/eed3si9n/gigahorse
object GigahorseClient {

  def main(args: Array[String]): Unit = {
    Gigahorse.withHttp(Gigahorse.config) { http =>
      val r = Gigahorse.url("https://api.github.com/users/scala-italy").get
      val f = http.run(r)
      val res = Await.result(f, 120.seconds)
      println(res.body)
    }
  }
}
