package com.kotlex.system.android

import android.content.res.AssetManager
import com.kotlex.system.io.closeCatched
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
        inputStream?.closeCatched()
    }
    return success
}

fun AssetManager.tryCopy(assetPath: String, target: File): Boolean {

    var inputStream: InputStream? = null
    var bufferedInputStream: BufferedInputStream? = null
    var fileOutputStream: FileOutputStream? = null

    try {
        inputStream = open(assetPath)
        bufferedInputStream = BufferedInputStream(open(assetPath))
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