import httpc.all._

object httpcExample extends App {

  val command = get("https://api.github.com/users/scala-italy",
                    headers = List(("User-Agent", "Awesome-Octocat-App")))

  // Run the command into an Either[HttpError, Response]
  run(command) match {
    case Left(error) ⇒ println(error)
    case Right(response) ⇒
      println(response.status)
      println(response.text)
      println(response.json)
  }
}
