ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

lazy val root = (project in file("."))
  .settings(
    name := "Lab_5",
    idePackagePrefix := Some("com.github.Punctuality"),
    libraryDependencies ++= Seq(
//      Spark dependency
      "org.apache.spark" %% "spark-core" % "3.3.2",
      "org.apache.spark" %% "spark-sql" % "3.3.2",
      "org.apache.spark" %% "spark-mllib" % "3.3.2",
    )
  )