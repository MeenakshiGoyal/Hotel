package com.knoldus.routes

import akka.http.scaladsl.model.StatusCodes.NoContent
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.knoldus.model.Hotel
import com.knoldus.service.HotelService
import jsonSupport.Protocols

class HotelRoutes(val hotelService: HotelService) extends Protocols{
  val route:Route = logRequestResult("HotelRoutes"){
    pathPrefix("hotels"){
      pathEndOrSingleSlash{
        get{
          complete{
            hotelService.getHotels()
          }
        }~
          post{
            entity(as[Hotel]){hotelForCreate =>
              complete{
                hotelService.createHotel(hotelForCreate)
              }
            }
          }
      }~
        pathPrefix(LongNumber){id =>
          get{
            complete{
              hotelService.getHotelById(id)
            }
          }~
            put{
              entity(as[Hotel]) { hotelForUpdate =>
                complete {
                  hotelService.update(id, hotelForUpdate)
                }
              }
            } ~
            delete {
              onSuccess(hotelService.deleteHotel(id)) { _ =>
                complete(NoContent)

              }
            }

        }
    }
  }

}
