import sttp.client3._

object Hello extends App {
  val backend = HttpURLConnectionBackend()
  val response = basicRequest
    .get(uri"https://api.github.com/users/scala-italy")
    .send(backend)
  println(response)
}
