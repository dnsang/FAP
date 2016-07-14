package fap

import com.typesafe.config.{Config, ConfigFactory}
import com.typesafe.scalalogging.LazyLogging
import fap.core.{PubMediator, WebServer}
import org.eclipse.jetty.server.nio.SelectChannelConnector
import org.eclipse.jetty.server.{Connector, Server}
import org.eclipse.jetty.util.thread.QueuedThreadPool
import fap.util.FapImplicits.ConfigImplicit

/**
  * Created by SangDang on 7/14/16.
  */
class JettyWebServer(pubMediator: PubMediator)(implicit config: Config) extends WebServer with LazyLogging {
  val _port: Int = config.getInt("http.jetty.port", 8080)
  val _host: String = config.getString("http.jetty.host", "0.0.0.0")
  val _nconnectors: Int = config.getInt("http.jetty.num_connector", 1)
  val _nacceptors: Int = config.getInt("http.jetty.num_acceptor", 4)
  val _acceptQueueSize: Int = config.getInt("http.jetty.accept_queue_size", 500)
  val _nminThreads: Int = 10
  val _nmaxThreads: Int = this._nminThreads * 2
  val _maxIdleTime: Int = 5000
  val _connMaxIdleTime: Int = this._maxIdleTime
  val _threadMaxIdleTime: Int = this._maxIdleTime
  val _server: Server = new Server
  val _thread: Thread = null

  protected def init() = {
    val _threadPool: QueuedThreadPool = new QueuedThreadPool
    _threadPool.setName("JettyThreadPoolServer")
    _threadPool.setMinThreads(this._nminThreads)
    _threadPool.setMaxThreads(this._nmaxThreads)
    _threadPool.setMaxIdleTimeMs(this._maxIdleTime)
    _server.setThreadPool(_threadPool)
    val connectors: Array[Connector] = new Array[Connector](this._nconnectors)
    (1 to _nconnectors) foreach (i => {
      val connector: SelectChannelConnector = new SelectChannelConnector
      connector.setHost(this._host)
      connector.setPort(this._port + i)
      connector.setMaxIdleTime(this._connMaxIdleTime)
      connector.setAcceptQueueSize(this._acceptQueueSize)
      connector.setThreadPool(_threadPool)
      connector.setAcceptors(this._nacceptors)
      connectors(i - 1) = connector
    })

    _server.setConnectors(connectors)
  }

  override def start(port: Int): Unit = {

  }


  override def stop(): Unit = {

  }

  override def restart(): Unit = {

  }

}
