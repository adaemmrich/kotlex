package com.kotlex.system.common


fun String.addPrefix(prefix: String): String {
    if (startsWith(prefix)) {
        return prefix + this
    }
    return this
}

fun String.addSuffix(suffix: String): String {
    if (endsWith(suffix)) {
        return this + suffix
    }
    return this
}