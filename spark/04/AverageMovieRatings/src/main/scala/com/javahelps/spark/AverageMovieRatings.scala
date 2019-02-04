package com.javahelps.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

object AverageMovieRatings {

    def mapToTuple(line: String): (Int, (Float, Int)) = {
        val fields = line.split(',')
        return (fields(1).toInt, (fields(2).toFloat, 1))
    }

    def main(args: Array[String]): Unit = {
        Logger.getLogger("org").setLevel(Level.ERROR)

        val sc = new SparkContext("local[*]", "AverageMovieRatings")

        // Read a text file
        var data = sc.textFile("/tmp/ml-latest-small/ratings.csv")

        // Extract the first row which is the header
        val header = data.first();

        // Filter out the header from the dataset
        data = data.filter(row => row != header)

        val result = data.map(mapToTuple)
          .reduceByKey((x, y) => (x._1 + y._1, x._2 + y._2))
          .map(x => (x._1, x._2._1 / x._2._2))
          .sortBy(_._2, false)
          .collect()

        result.foreach(println)
    }
}
