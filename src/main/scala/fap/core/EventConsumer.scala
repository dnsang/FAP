package fap.core

/**
  * Created by SangDang on 7/13/16.
  */
trait EventConsumer {
  def consume(event: Event)
}
