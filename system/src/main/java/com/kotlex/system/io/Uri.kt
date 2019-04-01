package com.kotlex.system.io

import android.net.Uri

fun Uri.isAssetUri(): Boolean {
    return this.toString().startsWith("//android_asset/")
}

fun Uri.toAssetPath(): String {
    if (isAssetUri()) {
        return path!!.removePrefix("/")
    } else {
        throw Exception("could convert uri to asset path. uri must be an asset uri: //android_asset/ ")
    }
}