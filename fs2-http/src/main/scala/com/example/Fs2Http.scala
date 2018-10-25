package com.example

import java.nio.channels.AsynchronousChannelGroup
import java.util.concurrent.Executors

import scala.concurrent.duration._
import cats.effect.{Concurrent, ContextShift, IO, Timer}
import fs2.Stream
import spinoco.fs2.http
import spinoco.fs2.http.HttpRequest
import spinoco.protocol.http.Uri

import scala.concurrent.{ExecutionContext, TimeoutException}

object Fs2Http extends App {

  implicit val _cxs: ContextShift[IO] = IO.contextShift(ExecutionContext.Implicits.global)
  implicit val _timer: Timer[IO] = IO.timer(ExecutionContext.Implicits.global)
  implicit val _concurrent: Concurrent[IO] = IO.ioConcurrentEffect(_cxs)
  implicit val AG: AsynchronousChannelGroup = AsynchronousChannelGroup.withThreadPool(Executors.newCachedThreadPool(spinoco.fs2.http.util.mkThreadFactory("fs2-http-spec-AG", daemon = true)))

  implicit val timeout = 2 seconds

  http.client[IO]().flatMap { client =>
    val request = HttpRequest.get[IO](Uri.https("github.com", "/Spinoco/fs2-http"))
    client.request(request).flatMap { resp =>
      Stream.eval(resp.bodyAsString)
    }.runLog.map {
      println
    }
  }
}
