package com.kotlex.rx

import io.reactivex.Maybe
import io.reactivex.Single

fun <T, R> Maybe<T>.chain(single: Single<R>): Maybe<T> {
    return this.doOnSuccess { single.blockingGet() }
}

fun <T, R> Maybe<T>.chain(single: Maybe<R>): Maybe<T> {
    return this.doOnSuccess { single.blockingGet() }
}