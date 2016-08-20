name := """play-tmr"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

resolvers += "spring cloudfoudnry" at "http://repo.spring.io/snapshot"

libraryDependencies ++= Seq(
  "org.springframework.cloud" % "spring-cloud-core" % "1.0.1.BUILD-SNAPSHOT",
  "org.cloudfoundry" % "auto-reconfiguration" % "1.11.0.BUILD-SNAPSHOT",
  "mysql" % "mysql-connector-java" % "5.1.34",
  "com.typesafe.play" %% "play-slick" % "1.1.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "1.1.0",
  "com.h2database" % "h2" % "1.4.190",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
  "org.slf4j" % "slf4j-api" % "1.7.10",
  specs2 % Test
)



fork in run := true