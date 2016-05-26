package com.example

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

import com.ning.http.client.AsyncHttpClientConfig
import play.api.libs.ws.ning._
import play.api.libs.ws._

// https://playframework.com
object Play {

  def main(args: Array[String]): Unit = {
    val builder = new AsyncHttpClientConfig.Builder()
    val ws: WSClient = new NingWSClient(builder.build())
    val url = "https://api.github.com/users/scala-italy"
    val res =
      ws.url(url).withHeaders("User-Agent" -> "Awesome-Octocat-App").get

    val x = Await.result(res, 1 second)
    println(x.body)
    ws.close
  }
}
