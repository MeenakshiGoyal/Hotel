package com.knoldus.service
import com.typesafe.config.ConfigFactory
import com.zaxxer.hikari.{HikariConfig, HikariDataSource}
import slick.jdbc.MySQLProfile
import slick.util.AsyncExecutor
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.ExecutionContext

class DatabaseService(implicit ec: ExecutionContext) {
/*
  private val hikariConfig = new HikariConfig()
  hikariConfig.setJdbcUrl(jdbcUrl)
  hikariConfig.setUsername(user)
  hikariConfig.setPassword(password)

  val dataSource = new HikariDataSource(hikariConfig)

  private val flywayService = new FlywayService(dataSource)
  println("Migrating database..")
  flywayService.migrateSchema()

  import driver.api._
  val db = Database.forDataSource(dataSource)

  val daoType = DAO(driver)
  db.createSession()
}*/

private def createConnection: MySQLProfile.backend.DatabaseDef = {
  val CONFIG = ConfigFactory.load()
  val DB_CONFIG = CONFIG.getConfig("db")

  val maxConnections: Int = DB_CONFIG.getInt("max-connections")
  val hikariConfig = new HikariConfig()
  hikariConfig.setJdbcUrl(DB_CONFIG.getString("url"))
  hikariConfig.setUsername(DB_CONFIG.getString("user"))
  hikariConfig.setPassword(DB_CONFIG.getString("password"))
  hikariConfig.setDriverClassName(DB_CONFIG.getString("driver"))
  hikariConfig.setMaximumPoolSize(maxConnections)
  hikariConfig.setConnectionTimeout(5000)

  val dataSource = new HikariDataSource(hikariConfig)
  val numberOfThreads = maxConnections

  Database.forDataSource(
  dataSource,
  Some(maxConnections),
  AsyncExecutor.apply("slick-async-executor", numberOfThreads, numberOfThreads, 1000, maxConnections)
  )
  }

  val db = createConnection

  }