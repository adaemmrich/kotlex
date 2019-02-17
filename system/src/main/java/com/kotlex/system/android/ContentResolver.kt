package com.kotlex.system.android

import android.content.ContentResolver
import android.net.Uri
import com.kotlex.system.io.closeCatched
import com.kotlex.system.io.writeTo
import java.io.BufferedInputStream
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream


fun ContentResolver.tryCopy(source: Uri, target: File): Boolean {
    var inputStream: InputStream? = null
    var bufferedInputStream: BufferedInputStream? = null
    var fileOutputStream: FileOutputStream? = null

    if (!target.parentFile.exists()) {
        target.parentFile.mkdirs()
    }

    try {
        inputStream = this.openInputStream(source)
        bufferedInputStream = BufferedInputStream(inputStream)
        fileOutputStream = FileOutputStream(target)
        bufferedInputStream.writeTo(fileOutputStream)

        return true
    } catch (e: Exception) {
    } finally {
        inputStream?.closeCatched()
        bufferedInputStream?.closeCatched()
        fileOutputStream?.closeCatched()
    }
    return false
}

