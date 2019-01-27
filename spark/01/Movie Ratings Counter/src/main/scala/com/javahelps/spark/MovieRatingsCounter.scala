package com.javahelps.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext


object MovieRatingsCounter {

    def main(args: Array[String]): Unit = {

        Logger.getLogger("org").setLevel(Level.ERROR)

        val sc = new SparkContext("local[*]", "MovieRatingsCounter")

        // Read a text file
        var data = sc.textFile("/tmp/ml-latest-small/ratings.csv")

        // Extract the first row which is the header
        val header = data.first();

        // Filter out the header from the dataset
        data = data.filter(row => row != header)

        val result = data.map(line => line.split(',')(2).toFloat) // Extract rating from line as float
          .countByValue() // Count number of occurrences of each number

        // Sort and print the result
        result.toSeq
          .sorted
          .foreach(println)
    }
}
