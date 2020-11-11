package com.example

import java.util.concurrent._

import cats.effect._
import cats.effect.Blocker

import org.http4s.{Header, Http, Request, Response, Uri}
import org.http4s.Method.GET
import org.http4s._
import org.http4s.client._
import org.http4s.implicits._

// http://http4s.org/
object Http4s extends cats.effect.IOApp {

  def run(args: List[String]): IO[ExitCode] = {
    val blockingPool = Executors.newFixedThreadPool(5)
    val blocker = Blocker.liftExecutorService(blockingPool)
    val httpClient: Client[IO] = JavaNetClientBuilder[IO](blocker).create

    val uri = uri"https://api.github.com/users/scala-italy"

    httpClient.expect[String](Request[IO](method = GET, uri = uri)
      .withHeaders(Header("User-Agent", "Awesome-Octocat-App")))
      .as(ExitCode.Success)

  }

}
