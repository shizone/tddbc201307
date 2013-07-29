import sbt._

object Dependencies {

  val scalaz = "org.scalaz" %% "scalaz-core" % "7.0.0"
  val scalatest = "org.scalatest" %% "scalatest" % "1.9.1"
  val junit = "junit" % "junit" % "4.11"

  val appDependencies = Seq(
    scalaz,
    scalatest % "test",
    junit % "test"
  )

}