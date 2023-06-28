package com.github.Punctuality.util

import java.io.{File, InputStreamReader}
import java.util.zip.GZIPInputStream
import scala.io.Source

object Decompressing {
  def decompressResource(resourcePath: String, to: Option[String] = None): (File, Long) = {
    val uncompressedStream = new GZIPInputStream(getClass.getClassLoader.getResourceAsStream(resourcePath))

    val uncompressedFile = to.fold(File.createTempFile(resourcePath.stripSuffix(".gz"), ".jsonl"))(new File(_))

    val uncompressedWriter = new java.io.FileWriter(uncompressedFile)

    val totalSize =
      Source
        .fromInputStream(uncompressedStream)
        .getLines()
        .foldLeft(0L) { (size, str) =>
          uncompressedWriter.write(str + "\n")
          size + str.length
        }

    uncompressedFile -> totalSize
  }

}
