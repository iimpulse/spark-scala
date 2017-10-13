package template.spark

import org.apache.spark.sql.functions._

final case class Person(firstName: String, lastName: String,
                        country: String, age: Int)

object Main extends InitSpark {
  def main(args: Array[String]) = {
    import spark.implicits._

    // Load up each line of the ratings data into an RDD
    val lines = sc.textFile("/Users/gargam/Projects/spark-scala/ml-100k/u.data")

    // Convert each line to a string, split it out by tabs, and extract the third field.
    // (The file format is userID, movieID, rating, timestamp)
    val ratings = lines.map(x => x.toString().split("\t")(2))

    // Count up how many times each value (rating) occurs
    val results = ratings.countByValue()

    // Sort the resulting map of (rating, count) tuples
    val sortedResults = results.toSeq.sortBy(_._1)

    // Print each result on its own line.
    sortedResults.foreach(println)

    close
  }
}
