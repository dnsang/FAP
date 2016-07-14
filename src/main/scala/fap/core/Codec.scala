package fap.core

import com.typesafe.config.Config

/**
  * Created by SangDang on 7/14/16.
  */
trait Codec[T] {
  def encode(obj: T): Array[Byte]

  def decode(buffer: Array[Byte]): T
}

case class DefaultCodec(config: Config) extends Codec[Array[Byte]] {
  override def encode(obj: Array[Byte]): Array[Byte] = obj

  override def decode(buffer: Array[Byte]): Array[Byte] = buffer
}

case class StringCodec(config: Config = null) extends Codec[String] {
  val charset =
    if (config == null) "UTF8"
    else
      try {
        config.getString("codec.encoding")
      } finally {
        "UTF8"
      }

  override def encode(obj: String): Array[Byte] = {
    if (obj == null) null
    else obj.getBytes(charset)
  }

  override def decode(buffer: Array[Byte]): String = {
    if (buffer == null) null
    else new String(buffer, charset)
  }
}
