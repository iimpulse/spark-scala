package template.spark

import org.apache.log4j.{Level, LogManager, Logger}
import org.apache.spark.sql.{DataFrameReader, SQLContext, SparkSession}
import org.apache.log4j.PropertyConfigurator
import org.apache.spark.SparkContext

trait InitSpark {
  PropertyConfigurator.configure("./log4j.properties")
  val spark: SparkSession = SparkSession.builder()
                            .appName("Spark example")
                            .master("local[*]")
                            .config("option", "some-value")
                            .getOrCreate()

  val sc: SparkContext = spark.sparkContext
  val sqlContext: SQLContext = spark.sqlContext
  def reader: DataFrameReader = spark.read
               .option("header", true)
               .option("inferSchema", true)
               .option("mode", "DROPMALFORMED")

  def readerWithoutHeader: DataFrameReader = spark.read
                            .option("header", true)
                            .option("inferSchema", true)
                            .option("mode", "DROPMALFORMED")
  private def init(): Unit = {
    sc.setLogLevel("ERROR")
    Logger.getLogger("org").setLevel(Level.ERROR)
    Logger.getLogger("akka").setLevel(Level.ERROR)
    LogManager.getRootLogger.setLevel(Level.ERROR)
  }

  init()

  def close(): Unit = {
    spark.close()
  }
}
