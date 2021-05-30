
/*package com.knoldus.bootstrap

import akka.actor.{ActorPath, ActorRef, ActorRefProvider, ActorSystem, ActorSystemImpl, Extension, ExtensionId, InternalActorRef, Props, Scheduler, Terminated}
import akka.dispatch.{Dispatchers, Mailboxes}
import akka.event.{EventStream, Logging, LoggingAdapter}
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

import com.knoldus.service.HotelService
import com.typesafe.config.ConfigFactory

import scala.concurrent.{ExecutionContextExecutor, Future}
import scala.concurrent.duration.Duration

object HotelMicroservices extends App{
  implicit val system = ActorSystem ("actor-system")
  implicit val executor = system.dispatcher
  implicit val materializer = ActorMaterializer()

  val bindingFuture = Http().bindAndHandleSync(route,"localhost",8091)

  val config = ConfigFactory.load()
  val logger = Logging(system,getClass)


}
*/