import scalariform.formatter.preferences._

val playVersion = "2.8.1"

val scalaVersion_2_13 = "2.13.2"

lazy val `play-joda-routes-binder` = project
  .in(file("."))
  .settings(publishSettings)
  .settings(
    name := "play-joda-routes-binder",
    organization := "com.github.tototoshi",
    version := "1.4.0-SNAPSHOT",
    scalaVersion := scalaVersion_2_13,
    crossScalaVersions := Seq(scalaVersion_2_13),
    scalacOptions ++= Seq("-feature", "-deprecation"),
    libraryDependencies ++= Seq(
      "com.typesafe.play" %% "play" % playVersion % "provided",
      "com.typesafe.play" %% "play-test" % playVersion % "test",
      "org.scalactic" %% "scalactic" % "3.1.2",
      "org.scalatest" %% "scalatest" % "3.1.2" % "test"
    ),
    resolvers ++= Seq(
        "typesafe" at "http://repo.typesafe.com/typesafe/releases"
    ),
    scalariformPreferences := scalariformPreferences.value
      .setPreference(AlignSingleLineCaseStatements, true)
      .setPreference(DoubleIndentConstructorArguments, true)
      .setPreference(DanglingCloseParenthesis, Preserve)
  )

val publishSettings = Seq(
  publishMavenStyle := true,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (version.value.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
    else Some("releases" at nexus + "service/local/staging/deploy/maven2")
  },
  publishArtifact in Test := false,
  pomExtra :=
    <url>https://github.com/tototoshi/play-joda-routes-binder</url>
    <licenses>
      <license>
        <name>Apache License, Version 2.0</name>
        <url>https://www.apache.org/licenses/LICENSE-2.0.html</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:tototoshi/play-joda-routes-binder.git</url>
      <connection>scm:git:git@github.com:tototoshi/play-joda-routes-binder.git</connection>
    </scm>
    <developers>
      <developer>
        <id>tototoshi</id>
        <name>Toshiyuki Takahashi</name>
        <url>https://tototoshi.github.io</url>
      </developer>
    </developers>
)
