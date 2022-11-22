import akka.actor.typed.scaladsl.Behaviors
import akka.actor.ActorSystem
import akka.http.scaladsl.model.ContentTypes
import akka.http.scaladsl.model.HttpEntity
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.Http
import com.typesafe.config.ConfigFactory
import akka.event.Logging

object NoyzServer extends App {

  implicit val system: ActorSystem = ActorSystem()

  val logger = Logging(system, "NoyzServer")

  val getAllConcerts: Route =
    path("api" / "concert") {
      get {
        // retrieve concert from db
        logger.info("GET ALL CONCERTS CALLED")

        ???
      }
    }

  val config = ConfigFactory.load()
  val host = config.getString("services.noyz-server.host")
  val port = config.getInt("services.noyz-server.port")
  Http().newServerAt(host, port).bind(getAllConcerts)

}
