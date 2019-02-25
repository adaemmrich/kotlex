package com.kotlex.system.io

import java.io.BufferedInputStream
import java.io.OutputStream

fun BufferedInputStream.writeTo(outputStream: OutputStream, bufferSize: Int = 2048) {
    val buffer = ByteArray(bufferSize)
    var readSize: Int

    do {
        readSize = this.read(buffer)
        outputStream.write(buffer)
    } while (readSize > 0)
}
