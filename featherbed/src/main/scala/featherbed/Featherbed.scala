package com.example

import java.net.URL
import com.twitter.util.Await

import com.twitter.finagle.http.Response

// https://github.com/finagle/featherbed
object Featherbed {

  def main(args: Array[String]): Unit = {
    val client = new featherbed.Client(
        new URL("https://api.github.com/users/scala-italy"))

    Await.result {
      val request = client
        .get("")
        .withHeaders("User-Agent" -> "Awesome-Octocat-App")
        .send[Response]()

      request.map { response =>
        println(response.contentString)
      }
    }
  }
}
