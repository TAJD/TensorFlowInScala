ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

lazy val root = (project in file("."))
  .settings(
    name := "tfScala"
  )

libraryDependencies += "com.microsoft.onnxruntime" % "onnxruntime" % "1.16.0"