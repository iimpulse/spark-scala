# _Spark-Scala-Demo_
A barebones project with scala, apache spark built using gradle. Spark-shell provides `spark` and `sc` variables pre-initialised, here I did the same using a *scala trait* that you can extend.
The main method in this project computes a pearson correlation matrix leveraging spark ml.

Credit To: https://github.com/faizanahemad/spark-gradle-template.git`

## Prerequisites
- [Java](https://java.com/en/download/)
- [Gradle](https://gradle.org/)
- [Scala](https://www.scala-lang.org/)

## Install
`Scala Plug In for Intellij`
### Clone the Repo
`git clone https://github.com/iimpulse/spark-scala.git`
### Building a JAR
`./gradlew clean build`
### Run
`./gradlew run`
### Clean Run
`./gradlew clean run`

## Useful Links
- [Spark Docs - Root Page](http://spark.apache.org/docs/latest/)
- [Spark Programming Guide](http://spark.apache.org/docs/latest/programming-guide.html)
- [Spark Latest API docs](http://spark.apache.org/docs/latest/api/)
- [Scala API Docs](http://www.scala-lang.org/api/2.12.1/scala/)
