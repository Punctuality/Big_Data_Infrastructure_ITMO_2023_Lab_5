package com.github.Punctuality

import org.apache.spark.rdd.RDD
import org.apache.spark.sql._

object TestSparkConnection {
  def main(args: Array[String]): Unit = {

    println("Attempting to connect to Spark...")

    val spark = SparkSession.builder.appName("TestSparkConnection")
    .master("local[*]")
    .config("spark.driver.host", "localhost")
    .config("spark.driver.bindAddress", "localhost")
    .getOrCreate()

    val sc = spark.sparkContext

    sc.listJars().foreach(jar => println(s"Added jars: $jar"))

    val input: RDD[String] = sc.textFile("src/main/resources/word_count_test.txt").cache()
    println("initial partition count:" + input.getNumPartitions)
    println(s"Scala version: ${scala.util.Properties.versionString}")
    println(s"Files: ${sc.listFiles()}")


    val counted = input
      .flatMap[String](_.split(' '))
      .countByValue()

    println(s"Result: ${counted.toList.map{
      case (word, count) => s"$word: $count"
    }.mkString(", ")}")
  }
}
