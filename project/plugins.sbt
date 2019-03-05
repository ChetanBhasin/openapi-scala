// Code auto-formatting with compile
addSbtPlugin("com.geirsson" % "sbt-scalafmt" % "1.5.1")

// Code style hints
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "1.0.0")

val sbtN4BuildVersion = "0.2.82"
// Build Plugin
addSbtPlugin("com.enfore" % "sbt-n4build" % sbtN4BuildVersion)

// Code coverage
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")

// Dependency graph generation
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.9.2")