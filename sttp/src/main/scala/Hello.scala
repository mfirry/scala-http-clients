import com.softwaremill.sttp._

object Hello {
  val request = sttp.get(uri"https://api.github.com/users/scala-italy")
  implicit val handler = HttpURLConnectionSttpHandler
  val response = request.send()
  println(response.body)
}