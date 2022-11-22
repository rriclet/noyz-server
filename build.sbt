import Dependencies._

Global / onChangedBuildSource := ReloadOnSourceChanges

ThisBuild / scalaVersion := "3.2.1"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.rriclet"
ThisBuild / organizationName := "rriclet"

libraryDependencies ++= {
  val akkaHttpVersion = "10.4.0"
  val akkaVersion = "2.7.0"
  val circeVersion = "0.14.3"

  Seq(
    "ch.qos.logback" % "logback-classic" % "1.2.10",
    "org.scalatest" %% "scalatest" % "3.2.14" % Test
    /*
  "com.typesafe.akka" %% "akka-persistence-typed" % akkaVersion,
  "com.datastax.oss" % "java-driver-core" % "4.13.0", // See https://github.com/akka/alpakka/issues/2556
  "com.typesafe.akka" %% "akka-persistence-cassandra" % "1.0.5",
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  "de.heikoseeberger" %% "akka-http-circe" % "1.39.2",
  "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test,
  "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVersion % Test,
     */
  ) ++ Seq(
    "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion
  ).map(_.cross(CrossVersion.for3Use2_13))
}
