package fap.core

/**
  * Created by SangDang on 7/12/16.
  */
trait WebServer {
  def start(port:Int)
  def stop()
  def restart()
}
