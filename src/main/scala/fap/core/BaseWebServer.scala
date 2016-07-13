package fap.core

/**
  * Created by SangDang on 7/12/16.
  */
trait BaseWebServer {
  def start(port:Int)
  def stop()
  def restart()
}
