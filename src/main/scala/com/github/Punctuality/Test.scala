package com.github.Punctuality

import com.github.Punctuality.util.Decompressing
import com.typesafe.scalalogging.LazyLogging
import org.apache.spark.sql._

object Test extends LazyLogging {
  def main(args: Array[String]): Unit = {

    println("Attempting decompression...")
    val (decompressedPath, decompSize) = Decompressing.decompressResource("openfoodfacts.gz", Some apply "src/main/resources/openfoodfacts.jsonl")
    println(s"Decompression complete: ${decompressedPath.getAbsolutePath} (total size: $decompSize)")

  }
}
