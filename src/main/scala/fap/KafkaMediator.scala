package fap

import fap.core.{Event, EventConsumer, EventMediator}

/**
  * Created by SangDang on 7/12/16.
  */
class KafkaMediator extends EventMediator {
  override def publish(event: Event): Unit = {

  }

  override def subscribe(eventName: List, consumer: EventConsumer, group: String = null): Unit = {

  }

  override def unsubscribe(): Unit = {}
}
