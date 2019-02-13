package com.javahelps.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

object ActionMovies {

    def main(args: Array[String]): Unit = {
        Logger.getLogger("org").setLevel(Level.ERROR)

        val sc = new SparkContext("local[*]", "ActionMovies")

        // Read a text file
        var data = sc.textFile("/tmp/ml-latest-small/movies.csv")

        // Extract the first row which is the header
        val header = data.first();

        // Filter out the header from the dataset
        data = data.filter(row => row != header)

        val result = data.map(row => row.split(','))
          .map(fields => (fields(1), fields(2)))
          .flatMapValues(x => x.split('|'))
          .filter(x => x._2 == "Action")
          .map(x => x._1)
          .collect()

        result.sorted
          .foreach(println)
    }
}