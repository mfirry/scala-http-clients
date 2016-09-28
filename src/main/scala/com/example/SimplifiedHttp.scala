package com.example
import scalaj.http.Http

// https://github.com/scalaj/scalaj-http
object SimplifiedHttp {

  val response = Http("https://api.github.com/users/scala-italy")
    .header("User-Agent", "Awesome-Octocat-App")
    .asString

  println(response.body)
}
