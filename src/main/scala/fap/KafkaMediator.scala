package fap

import fap.core._

import scala.concurrent.Future

/**
  * Created by SangDang on 7/12/16.
  */
case class KafkaPubMediator() extends PubMediator {
  override def publish(event: Event): Unit = {

  }

  override def publishAsync(event: Event): Future[Boolean] = {
    null
  }


  override def publishSync(event: Event): Boolean = {
    false
  }
}

case class KafkaSubMediator(val group: String, val names: Set[String]) extends SubMediator {
  override def pull(timeout: Long): Iterable[Event] = ???

  override def commitSync(): Unit = ???

  override def commitAsync(): Unit = ???
}

