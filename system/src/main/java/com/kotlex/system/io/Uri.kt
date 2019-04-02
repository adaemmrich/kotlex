package com.kotlex.system.io

import android.net.Uri
import com.kotlex.system.android.AndroidConst

fun Uri.isAssetUri(): Boolean {
    return this.toString().startsWith(AndroidConst.ANDROID_ASSET_PREFIX)
}

fun Uri.toAssetPath(): String {
    if (isAssetUri()) {
        return path!!.removePrefix("/android_asset/")
    } else {
        throw Exception("could convert uri to asset path. uri must be an asset uri: //android_asset/ ")
    }
}