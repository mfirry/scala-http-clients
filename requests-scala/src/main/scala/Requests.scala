package com.example

object Requests {
  def main(args: Array[String]): Unit = {
    val r = requests.get("https://api.github.com/users/scala-italy")

    println(r.text)
  }

}