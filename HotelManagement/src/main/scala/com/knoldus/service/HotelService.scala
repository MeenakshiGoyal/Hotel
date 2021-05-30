package com.knoldus.service
import com.knoldus.db.HotelSchema
import com.knoldus.model.Hotel
import slick.jdbc.MySQLProfile
import slick.lifted.TableQuery

import scala.concurrent.{ExecutionContext, Future}

class HotelService( databaseService : MySQLProfile.backend.DatabaseDef)(implicit executionContext: ExecutionContext)extends TableQuery (new HotelSchema(_)) {

  def insertHotel(hotel: Hotel): Future[Option[Long]] = {
    databaseService.run(this += hotel)
  }


  /*
  def getHotels():Future[Seq[Hotel]] = db.run(hotels.result)

  def getHotelById(id:Long): Future[Option[Hotel]] = db.run(hotels.filter(_.id === id).result.headOption)

  def getHotelByName(name:String):Future[Seq[Hotel]] = db.run(hotels.filter(_.name === name).result)

  def update(id: Long, toUpdate: Hotel): Future[Option[Hotel]] = getHotelById(id).flatMap {
    case Some(hotel) => {
      val updatedHotel = Hotel(hotel.id, toUpdate.name, toUpdate.address, toUpdate.zip)
      db.run(hotels.filter(_.id === id).update(updatedHotel)).map(_ => Some(updatedHotel))
    }
    case None => Future.successful(None)
  }

  def deleteHotel(id: Long):Future[Int] = db.run(hotels.filter(_.id === id).delete)
*/
}
