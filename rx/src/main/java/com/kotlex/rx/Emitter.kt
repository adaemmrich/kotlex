package com.kotlex.rx

import io.reactivex.CompletableEmitter
import io.reactivex.MaybeEmitter
import io.reactivex.ObservableEmitter
import io.reactivex.SingleEmitter

inline fun <T> ObservableEmitter<T>.unDisposed(function: ObservableEmitter<T>.() -> Unit) {
    if (!this.isDisposed) function()
}

inline fun <T> SingleEmitter<T>.unDisposed(function: SingleEmitter<T>.() -> Unit) {
    if (!this.isDisposed) function()
}

inline fun <T> MaybeEmitter<T>.unDisposed(function: MaybeEmitter<T>.() -> Unit) {
    if (!this.isDisposed) function()
}

inline fun CompletableEmitter.unDisposed(function: CompletableEmitter.() -> Unit) {
    if (!this.isDisposed) function()
}
