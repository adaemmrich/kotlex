package com.kotlex.system.io

import java.io.Closeable

fun Closeable.closeCatched() {
    try {
        this.close()
    } catch (ignored: Exception) {
    }
}