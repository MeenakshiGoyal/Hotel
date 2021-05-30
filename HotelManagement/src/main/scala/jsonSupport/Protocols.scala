package jsonSupport

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import com.knoldus.model.Hotel
import spray.json.DefaultJsonProtocol

trait Protocols extends SprayJsonSupport with DefaultJsonProtocol{
  implicit val hotelFormat = jsonFormat4(Hotel)

}
