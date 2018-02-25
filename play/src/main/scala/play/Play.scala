package com.example

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import play.shaded.ahc.org.asynchttpclient._
import play.api.libs.ws._
import play.api.libs.ws.ahc.{AhcConfigBuilder, StandaloneAhcWSClient}

// https://playframework.com
object Play {

  def main(args: Array[String]): Unit = {
    val ahcConfig = new AhcConfigBuilder().build()
    val w =  new DefaultAsyncHttpClient(ahcConfig)
    val url = "https://api.github.com/users/scala-italy"
    val ws = new StandaloneAhcWSClient(w)(null)
    val res =
      ws.url(url).addHttpHeaders("User-Agent" -> "Awesome-Octocat-App").get

    val x = Await.result(res, 1 second)
    println(x.body)
    ws.close
  }
}
