package com.kotlex.system.io

import java.io.InputStream
import java.io.OutputStream

fun InputStream.writeTo(outputStream: OutputStream) {
    outputStream.write(readBytes())
}

