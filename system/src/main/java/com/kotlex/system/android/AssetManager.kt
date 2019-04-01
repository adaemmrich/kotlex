package com.kotlex.system.android

import android.content.res.AssetManager
import android.net.Uri
import com.kotlex.system.io.toAssetPath
import com.kotlex.system.io.writeTo
import java.io.BufferedInputStream
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream


private const val FILE_ANDROID_ASSET = "file:///android_asset/"


fun AssetManager.isAssetPath(src: String): Boolean {
    return src.startsWith(FILE_ANDROID_ASSET)
}

/**
 * opens the Asset to test if it's readable
 */
fun AssetManager.isAssetAvailable(assetPath: String): Boolean {
    if (!assetPath.startsWith(FILE_ANDROID_ASSET)) return false

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

fun AssetManager.isAssetAvailable(uri: Uri): Boolean {
    return isAssetAvailable(uri.toAssetPath())
}

fun AssetManager.copy(uri: Uri, target: File) {
    copy(uri.toAssetPath(), target)
}

fun AssetManager.listUris(path: String): ArrayList<Uri> {
    val files = list(path)
    val uris = ArrayList<Uri>()

    if (files != null) {
        uris.addAll(files.map { Uri.parse("$path$it") })
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
        copyFile(assetFile, File(target, assetFile))
    }
}

fun AssetManager.copyFile(assetPath: String, target: File) {
    var inputStream: InputStream? = null
    var bufferedInputStream: BufferedInputStream? = null
    var fileOutputStream: FileOutputStream? = null

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