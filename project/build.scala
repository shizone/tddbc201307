import sbt._
import sbt.Keys._
import Dependencies._
import com.twitter.sbt._

object AppBuilder extends Build {
  
  val appSettings = Seq(
    name := "tddbc201307",
    organization := "com.example",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "2.10.2"
  )

  lazy val app = Project("my_project", file("."))
    .settings(appSettings : _*)
    .settings(GitProject.gitSettings : _*)
    .settings(BuildProperties.newSettings : _*)
    .settings(PackageDist.newSettings : _*)
    .settings(ReleaseManagement.newSettings : _*)
    .settings(VersionManagement.newSettings : _*)
    .settings(libraryDependencies ++= appDependencies)

}