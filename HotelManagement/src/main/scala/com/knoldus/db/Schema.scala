package com.knoldus.db

import com.knoldus.model.Hotel
import slick.jdbc.MySQLProfile
import slick.lifted.{ProvenShape, Tag}
import slick.jdbc.MySQLProfile.api._

class HotelSchema(tag: Tag) extends Table[Hotel](tag,"Hotels"){

  def id = column[Long]("Hotel_id" , O.PrimaryKey,O.AutoInc)

  def name = column[String]("Hotel_Name")

  def address = column[String]("Hotel_address")

  def zip = column[String]("zip")

  //override def * = (id.?, name, address, zip) <> ((Hotel.apply _).tupled, Hotel.unapply)
  def * : ProvenShape[Hotel] = (id.?, name, address, zip) <> (Hotel.tupled, Hotel.unapply)
}