ThisBuild / name := "test_scalatest"
ThisBuild / version := "0.1"
ThisBuild / scalaVersion := "2.12.7"
ThisBuild / concurrentRestrictions in Global := Seq(Tags.limit(Tags.Test, 10))

lazy val root = (project in file("."))
  .aggregate(specs)
  .dependsOn(specs)


lazy val testkit = (project in file("testkit"))
  .settings(
    libraryDependencies ++= Seq(
      "org.pegdown" % "pegdown" % "1.6.0",
      "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2",
      "org.scalatest" %% "scalatest" % "3.0.5",
      "com.github.t3hnar" %% "scalax" % "3.4",
      "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0"
    )
  )

lazy val specs = (project in file("specs"))
  .aggregate(testkit)
  .dependsOn(testkit)
  .settings(
    testOptions in Test := Seq(
      Tests.Argument(TestFrameworks.ScalaTest, "-h"),
      Tests.Argument(TestFrameworks.ScalaTest, "target/test-reports-html"),
      Tests.Argument(TestFrameworks.ScalaTest, "-u"),
      Tests.Argument(TestFrameworks.ScalaTest, "target/test-reports"),
      Tests.Argument(TestFrameworks.ScalaTest, "-oDF")
    )
  )
