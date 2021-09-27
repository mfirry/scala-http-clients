name := """scala-http-clients"""

version := "1.2.13.0"

ThisBuild / scalafmtOnCompile := true

val scalaV = "2.13.6"

lazy val dispatch =
  (project in file("dispatch"))
    .settings(
      scalaVersion := scalaV,
      libraryDependencies ++= Seq(
        "org.dispatchhttp" %% "dispatch-core" % "1.2.0"
      )
    )

lazy val gigahorse =
  (project in file("gigahorse"))
    .settings(
      scalaVersion := scalaV,
      libraryDependencies ++= Seq(
        "com.eed3si9n" %% "gigahorse-core" % "0.5.0",
        "com.eed3si9n" %% "gigahorse-asynchttpclient" % "0.5.0"
      )
    )

lazy val http4s =
  (project in file("http4s"))
    .settings(
      scalaVersion := scalaV,
      libraryDependencies ++= Seq(
        "org.http4s" %% "http4s-dsl" % "0.23.4",
        "org.http4s" %% "http4s-blaze-client" % "0.23.4"
      )
    )

lazy val play =
  (project in file("play"))
    .settings(
      scalaVersion := scalaV,
      libraryDependencies ++= Seq(
        "com.typesafe.play" %% "play-ahc-ws-standalone" % "2.1.2",
        "com.typesafe.play" %% "play-ws-standalone-json" % "2.1.2"
      )
    )

lazy val scalaj =
  (project in file("scalaj"))
    .settings(
      scalaVersion := scalaV,
      libraryDependencies ++= Seq(
        "org.scalaj" %% "scalaj-http" % "2.4.2"
      )
    )

lazy val `naive-http` =
  (project in file("naive-http"))
    .settings(
      scalaVersion := scalaV,
      libraryDependencies ++= Seq(
        "io.shaka" %% "naive-http" % "122"
      ),
      resolvers += ("Tim Tennant's repo" at "http://dl.bintray.com/timt/repo/")
        .withAllowInsecureProtocol(true)
    )

lazy val sttp =
  (project in file("sttp"))
    .settings(
      scalaVersion := scalaV,
      libraryDependencies ++= Seq(
        "com.softwaremill.sttp.client3" %% "core" % "3.1.1"
      )
    )

lazy val requests =
  (project in file("requests-scala"))
    .settings(
      scalaVersion := scalaV,
      libraryDependencies ++= Seq(
        "com.lihaoyi" %% "requests" % "0.6.9"
      )
    )

lazy val root = project
  .in(file("."))
  .aggregate(
    gigahorse,
    scalaj,
    sttp,
    play,
    requests,
    http4s,
    `naive-http`,
    dispatch
  )
