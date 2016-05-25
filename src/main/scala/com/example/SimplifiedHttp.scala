package com.example
import scalaj.http.Http

// https://github.com/scalaj/scalaj-http
object SimplifiedHttp {

  def main(args: Array[String]): Unit = {
    val response = Http("https://api.github.com/users/unicredit")
      .header("User-Agent", "Awesome-Octocat-App")
      .asString
    println(response.body)
  }
}
