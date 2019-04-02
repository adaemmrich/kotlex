package com.kotlex.system.android

import android.content.res.AssetManager
import android.net.Uri
import com.kotlex.system.android.AndroidConst.ANDROID_ASSET_PREFIX
import com.kotlex.system.io.toAssetPath
import com.kotlex.system.io.writeTo
import java.io.BufferedInputStream
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream


val AssetManager.defaultDirs: Array<String>
    get() {
        return arrayOf("webkit", "sounds", "images")
    }

/**
 * opens the Asset to test if it's readable
 */
fun AssetManager.isAssetFileAvailable(assetPath: String): Boolean {

    var inputStream: InputStream? = null
    var success = false
    try {
        inputStream = open(assetPath)
        success = true
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        kotlin.runCatching { inputStream?.close() }
    }
    return success
}

fun AssetManager.isAssetFileAvailable(uri: Uri): Boolean {
    return isAssetFileAvailable(uri.toAssetPath())
}

fun AssetManager.copy(uri: Uri, target: File) {
    copy(uri.toAssetPath(), target)
}

fun AssetManager.listUris(path: String): ArrayList<Uri> {
    val files = list(path)
    val uris = ArrayList<Uri>()

    if (files != null) {
        uris.addAll(files.map { Uri.parse("$ANDROID_ASSET_PREFIX$path/$it") }
        )
    }
    return uris
}


fun AssetManager.copy(assetPath: String, target: File) {
    val subFiles = list(assetPath) ?: throw IllegalArgumentException("asset not available")

    if (subFiles.isEmpty()) {
        copyFile(assetPath, target)
    } else {
        copyDir(assetPath, target)
    }
}

fun AssetManager.copyDir(assetDir: String, target: File) {

    val subPaths = list(assetDir)!!
    for (assetFile in subPaths) {
        copyFile("$assetDir/$assetFile", File(target, assetFile))
    }
}

fun AssetManager.copyFile(assetPath: String, target: File) {
    var inputStream: InputStream? = null
    var bufferedInputStream: BufferedInputStream? = null
    var fileOutputStream: FileOutputStream? = null

    target.parentFile.mkdirs()

    try {
        inputStream = open(assetPath)
        bufferedInputStream = BufferedInputStream(open(assetPath))
        fileOutputStream = FileOutputStream(target)
        bufferedInputStream.writeTo(fileOutputStream)
    } finally {
        runCatching { inputStream?.close() }
        runCatching { bufferedInputStream?.close() }
        runCatching { fileOutputStream?.close() }
    }
}