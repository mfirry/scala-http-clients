package com.example
import org.http4s._, org.http4s.dsl._
import org.http4s.client.blaze._
import scalaz.concurrent.Task

// http://http4s.org/
object Http4s {

  def main(args: Array[String]): Unit = {

    val header = Header("User-Agent", "Awesome-Octocat-App")
    val client = PooledHttp1Client()

    // there might be a better way to build a Task[Request]
    val req = Task.now(
        Request(headers = Headers(header),
                uri = Uri.uri("https://api.github.com/users/scala-italy")))

    // we're blocking on purpose
    val x = client.fetchAs[String](req).unsafePerformSync.mkString
    println(x)

    client.shutdownNow()
  }
}
