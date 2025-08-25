name := """scala-http-clients"""

version := "1.2.13.15"

ThisBuild / scalafmtOnCompile := true

val scalaV = "3.3.6"

lazy val dispatch =
  (project in file("dispatch"))
    .settings(
      scalaVersion := scalaV,
      libraryDependencies ++= Seq(
        "org.dispatchhttp" %% "dispatch-core" % "2.0.0"
      )
    )

lazy val gigahorse =
  (project in file("gigahorse"))
    .settings(
      scalaVersion := scalaV,
      libraryDependencies ++= Seq(
        "com.eed3si9n" %% "gigahorse-core" % "0.9.3",
        "com.eed3si9n" %% "gigahorse-asynchttpclient" % "0.9.3"
      )
    )

lazy val http4s =
  (project in file("http4s"))
    .settings(
      scalaVersion := scalaV,
      libraryDependencies ++= Seq(
        "org.http4s" %% "http4s-dsl" % "0.23.9",
        "org.http4s" %% "http4s-blaze-client" % "0.23.9"
      )
    )

lazy val play =
  (project in file("play"))
    .settings(
      scalaVersion := scalaV,
      libraryDependencies ++= Seq(
        "org.playframework" %% "play-ahc-ws-standalone" % "3.0.7",
        "org.playframework" %% "play-ws-standalone-json" % "3.0.7"
      )
    )

lazy val `naive-http` =
  (project in file("naive-http"))
    .settings(
      scalaVersion := scalaV,
      libraryDependencies ++= Seq(
        "io.shaka" %% "naive-http" % "126"
      ),
      resolvers += ("Tim Tennant's repo" at "http://dl.bintray.com/timt/repo/")
        .withAllowInsecureProtocol(true)
    )

lazy val sttp =
  (project in file("sttp"))
    .settings(
      scalaVersion := scalaV,
      libraryDependencies ++= Seq(
        "com.softwaremill.sttp.client3" %% "core" % "3.9.7"
      )
    )

lazy val requests =
  (project in file("requests-scala"))
    .settings(
      scalaVersion := scalaV,
      libraryDependencies ++= Seq(
        "com.lihaoyi" %% "requests" % "0.9.0"
      )
    )

lazy val root = project
  .in(file("."))
  .aggregate(
    dispatch,
    gigahorse,
    http4s,
    play,
    requests,
    sttp
  )
