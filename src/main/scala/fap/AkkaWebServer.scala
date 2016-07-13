package fap

import fap.core.{BaseEventProducer, WebServer, EventProducer, PubMediator}

/**
  * Created by SangDang on 7/13/16.
  */
class AkkaWebServer(pubMediator: PubMediator) extends BaseEventProducer(pubMediator) with WebServer {

  override def start(port: Int): Unit = {

  }

  override def stop(): Unit = {

  }

  override def restart(): Unit = {

  }
}

