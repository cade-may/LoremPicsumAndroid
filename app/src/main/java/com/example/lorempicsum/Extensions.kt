package com.example.lorempicsum

import android.content.res.Resources
import android.view.View
import android.view.ViewGroup

/**
 * Used to set margins to a view programmatically
 */
fun View.setMargins(
    left: Int,
    top: Int,
    right: Int,
    bottom: Int
) {
    val params = this.layoutParams as ViewGroup.MarginLayoutParams
    params.setMargins(left.toPx(), top.toPx(), right.toPx(), bottom.toPx())
    this.layoutParams = params
}

/**
 * Used to convert a value from px (pixels) to a value of dp (density independent pixels)
 */
fun Int.toDp(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()

/**
 * Used to convert a value from dp (density independent pixels) to a value of px (pixels)
 */
fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()