package com.example

import httpc.all._

// https://github.com/amrhassan/scala-httpc
object httpcExample {

  val command = get("https://api.github.com/users/scala-italy",
                    headers = List(userAgent("Awesome-Octocat-App")))

  // Run the command into an Either[HttpError, Response]
  run(command) match {
    case Left(error) ⇒ println(error)
    case Right(response) ⇒
      println(response.status)
      println(response.text)
      println(response.json)
  }
}
