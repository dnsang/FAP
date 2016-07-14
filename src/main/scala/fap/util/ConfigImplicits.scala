package fap.util

import java.util.Map.Entry
import java.util.function.Consumer

import com.typesafe.config.{Config, ConfigValue}

/**
  * Created by SangDang on 7/14/16.
  */
object FapImplicits {

  implicit class ConfigImplicit(val config: Config) {
    def getInt(path: String, default: Int): Int = {
      try {
        config.getInt(path)
      } catch {
        case _ => default
      }
    }

    def getLong(path: String, default: Long): Long = {
      try {
        config.getLong(path)
      } catch {
        case _ => default
      }
    }

    def getDouble(path: String, default: Double): Double = {
      try {
        config.getDouble(path)
      } catch {
        case _ => default
      }
    }

    def getString(path: String, default: String): String = {
      try {
        config.getString(path)
      } catch {
        case _ => default
      }
    }

    def get(path: String, default: AnyRef): AnyRef = {
      try {
        config.getAnyRef(path)
      } catch {
        case _ => default
      }
    }

    def print(): Unit = {
      config.entrySet().forEach(new Consumer[Entry[String, ConfigValue]] {
        override def accept(t: Entry[String, ConfigValue]): Unit = {
          println(t.getKey + ":" + t.getValue.toString)
        }
      })
    }
  }


}
