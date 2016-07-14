name := "FAP"

version := "1.0"

scalaVersion := "2.11.8"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"
resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"
libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.3.4"
libraryDependencies += "com.typesafe" % "config" % "1.3.0"
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.4.0"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.7"
libraryDependencies ++= Seq("org.slf4j" % "slf4j-api" % "1.7.5",
  "org.slf4j" % "slf4j-simple" % "1.7.5")

libraryDependencies ++= Seq("org.glassfish.jersey.containers" % "jersey-container-servlet-core" % "2.0",
  "org.glassfish.jersey.media" % "jersey-media-json-jackson" % "2.0",
  "org.eclipse.jetty.aggregate" % "jetty-all" % "8.1.17.v20150415"
)

libraryDependencies += "org.scalactic" %% "scalactic" % "2.2.6"
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"