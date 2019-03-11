package com.javahelps.spark

import java.nio.charset.CodingErrorAction

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

import scala.io.{Codec, Source}

object AverageMovieRatings {

    def mapToTuple(line: String): (Int, (Float, Int)) = {
        val fields = line.split(',')
        return (fields(1).toInt, (fields(2).toFloat, 1))
    }

    def loadMovieNames(): Map[Int, String] = {

        // Handle character encoding issues
        implicit val codec = Codec("UTF-8")
        codec.onMalformedInput(CodingErrorAction.REPLACE)
        codec.onUnmappableCharacter(CodingErrorAction.REPLACE)

        var movieNames: Map[Int, String] = Map()

        // Read lines from movies.csv into Iterator. Drop the first (header) row.
        val lines = Source.fromFile("/tmp/ml-latest-small/movies.csv").getLines().drop(1)
        for (line <- lines) {
            val fields = line.split(',')
            movieNames += (fields(0).toInt -> fields(1))
        }
        return movieNames
    }

    def main(args: Array[String]): Unit = {
        Logger.getLogger("org").setLevel(Level.ERROR)

        val sc = new SparkContext("local[*]", "AverageMovieRatings")

        // Broadcast the movie names
        val names = sc.broadcast(loadMovieNames())

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
          .map(x => (names.value(x._1), x._2))
          .collect()

        result.foreach(println)
    }
}