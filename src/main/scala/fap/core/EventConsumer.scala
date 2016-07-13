package fap.core

/**
  * Created by SangDang on 7/13/16.
  */
trait EventConsumer {
  def consume(event: Event)

  def consume(events: Iterable[Event])

  def consumeThenCommit(event: Event)

  def consumeThenCommit(events: Iterable[Event])

  def processEvent(event: Event): Boolean
}

abstract class BaseEventConsumer(subMediator: SubMediator) extends EventConsumer {
  override def consume(event: Event): Unit = ???

  override def consumeThenCommit(event: Event): Unit = ???

  override def consumeThenCommit(events: Iterable[Event]): Unit = ???

  override def consume(events: Iterable[Event]): Unit = ???
}
