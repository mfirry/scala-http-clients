name := """schlepp"""

version := "0.1.0"

scalaVersion := "2.11.8"

libraryDependencies += "io.github.finagle" %% "featherbed-core" % "0.1.0-SNAPSHOT" exclude("io.netty", "netty")
libraryDependencies += "io.github.finagle" %% "featherbed-circe" % "0.1.0-SNAPSHOT"

libraryDependencies += "net.databinder.dispatch" %% "dispatch-core" % "0.11.2"

lazy val http4sVersion = "0.13.2a"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.http4s" %% "http4s-blaze-client" % http4sVersion
)

libraryDependencies ++= Seq(
   "com.typesafe.play" %% "play-ws" % "2.4.6"
)

libraryDependencies += "org.scalaj" %% "scalaj-http" % "2.3.0"

reformatOnCompileSettings
