import com.softwaremill.sttp._

object Hello extends App {
  val request = sttp.get(uri"https://api.github.com/users/scala-italy")
  implicit val handler = HttpURLConnectionBackend()
  val response = request.send()
  println(response)
}