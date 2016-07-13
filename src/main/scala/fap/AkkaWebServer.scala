package fap

import fap.core.{BaseWebServer, EventMediator, EventProducer}

/**
  * Created by SangDang on 7/13/16.
  */
class AkkaWebServer extends BaseWebServer with EventProducer{
  override def start(port: Int): Unit = {

  }

  override def stop(): Unit = {

  }

  override def restart(): Unit = {

  }

  override val eventMediator: EventMediator = null
}
