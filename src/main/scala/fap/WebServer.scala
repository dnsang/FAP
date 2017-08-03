package fap

import java.io.File

import com.typesafe.config.ConfigFactory
import fap.util.FapImplicits._

/**
  * Created by SangDang on 7/14/16.
  */
object WebServer extends App {
  println("Start Fap WebServer")
  val config =ConfigFactory.parseFile(new File("config/default.conf"))

  //  config.print
  println(config.getAnyRef("http.jetty.host"))
  println(config.getAnyRef("http.jetty"))
  println(config.getAnyRef("http"))
  //  config.getAnyRef("http.not_found")
}
