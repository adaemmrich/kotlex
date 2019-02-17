package com.kotlex.system.io

import android.webkit.MimeTypeMap
import java.io.*


val File.mimeType: String?
    get() {
        var mime = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension)
        if (mime == null) {
            mime = getMimeTypeFromUnKnownExtension(extension)
        }
        return mime
    }

fun File.deleteChildren() {
    var success = true
    if (this.isDirectory) {
        listFiles().forEach { success = success && it.delete() }
    }
}


fun File.tryCopy(target: File): Boolean {
    if (!target.parentFile.exists()) {
        target.parentFile.mkdirs()
    }

    var inputStream: InputStream? = null
    var bufferedInputStream: BufferedInputStream? = null
    var fileOutputStream: FileOutputStream? = null

    try {
        inputStream = FileInputStream(this)
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


private fun getMimeTypeFromUnKnownExtension(extension: String): String? {

    if (extension == "webp") {
        return "image/webp"
    }
    if (extension == "weba") {
        return "audio/webm"
    }
    return if (extension == "webm") {
        "video/webm"
    } else null

}
