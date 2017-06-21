package com.example

import fs2._
import fs2.util.syntax._
import spinoco.fs2.http
import spinoco.fs2.http.HttpRequest
import spinoco.protocol.http.header.value.{HeaderCodecDefinition, HttpMediaRange}
// import spinoco.fs2.http.Resources._ // use when updating to 0.1.4
import spinoco.protocol.http.Uri
import spinoco.protocol.http.header.value.AgentVersion
import spinoco.protocol.http.header._
import spinoco.protocol.http.header.value.MediaType

object Fs2Http extends App {

  // TO BE REMOVED AFTER UPGRADE TO 0.1.4 - BEGIN
  import java.nio.channels.AsynchronousChannelGroup
  import java.util.concurrent.Executors
  import fs2.{Scheduler, Strategy}

  val ES = Executors.newCachedThreadPool(Strategy.daemonThreadFactory("AG"))
  implicit val S = Strategy.fromExecutor(ES)
  implicit val Sch = Scheduler.fromScheduledExecutorService(Executors.newScheduledThreadPool(4, Strategy.daemonThreadFactory("S")))
  implicit val AG = AsynchronousChannelGroup.withThreadPool(ES)
  // TO BE REMOVED AFTER UPGRADE TO 0.1.4 - END


  val task = http.client[Task]().flatMap { client =>

    val request = HttpRequest
      // .get[Task](Uri.https("github.com", "/scala-italy"))
      .get[Task](Uri.https("api.github.com", "/users/scala-italy"))
      .withHeader(Accept(List(HttpMediaRange.One(MediaType.`application/json`, None))))
      .withHeader(`User-Agent`(AgentVersion("Awesome-Octocat-App")))

    client.request(request).flatMap { resp =>
      Stream.eval(resp.withUtf8Body)
    }.runLog.map {
      println
    }
  }

  task.unsafeAttemptRun()
}
