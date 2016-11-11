package com.example

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

import spray.http._
import spray.client.pipelining._
import akka.actor.ActorSystem

object sprayExample extends App {

  import system.dispatcher // execution context for futures
  implicit val system = ActorSystem()

  val pipeline: HttpRequest => Future[HttpResponse] = sendReceive

  val response: Future[HttpResponse] = pipeline(
      Get("https://api.github.com/users/scala-italy"))
  val x = Await.result(response, 2 second)
  println(x.entity.asString)
}
