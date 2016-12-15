name := "html-fp"

version := "20161217"

scalaVersion := "2.11.7"

organization := "se.kodiak.tools"

credentials += Credentials(Path.userHome / ".ivy2" / ".tools")

publishTo := Some("se.kodiak.tools" at "http://yamr.kodiak.se/maven")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.0.13"
