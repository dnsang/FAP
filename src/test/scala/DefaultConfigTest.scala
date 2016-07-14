/**
  * Created by SangDang on 7/14/16.
  */

import com.typesafe.config.ConfigFactory
import org.scalatest.FlatSpec
import fap.util.FapImplicits.ConfigImplicit
import java.io.File

class JettyConfigTest extends FlatSpec {
  "Default Config" should " load default value " in {
    val config = ConfigFactory.load().withFallback(ConfigFactory.parseFile(new File("config/default.conf")))
    config.print
  }
}
