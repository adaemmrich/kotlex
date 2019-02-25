package com.kotlex.view


import android.view.View
import android.view.View.VISIBLE
import android.view.ViewPropertyAnimator

fun View.hide(): ViewPropertyAnimator {
    val animator = this.animate().alpha(0f)
    animator.withEndAction { this.visibility = View.INVISIBLE }

    return animator
}

fun View.show(): ViewPropertyAnimator {
    val animator = this.animate().alpha(1f)
    animator.withEndAction { }
    this.visibility = VISIBLE

    return animator
}

fun View.animateVisibility(visible: Boolean): ViewPropertyAnimator {
    return if (visible) show() else hide()
}


fun View.isVisible() = visibility == View.VISIBLE
fun View.isInvisible() = visibility == View.INVISIBLE
fun View.isGone() = visibility == View.GONE


