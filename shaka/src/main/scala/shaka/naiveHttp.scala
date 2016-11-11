package com.example

import io.shaka.http.Http.http
import io.shaka.http.Request.{GET, POST}
import io.shaka.http.HttpHeader.USER_AGENT

// https://github.com/timt/naive-http
object naiveHttp extends App {

  val response = http(
      GET("https://api.github.com/users/scala-italy").header(
          USER_AGENT, "Awesome-Octocat-App"))

  println(response.entityAsString)
}
