package com.eshc.travelplatform.util

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics

object DisplayMetricsUtil {

    fun convertDpToPixel(dp: Float, context: Context): Float {
        return dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }

}

fun Int.pxToDp() : Int = (this / Resources.getSystem().displayMetrics.density).toInt()

fun Int.dpToPx() : Int = (this * Resources.getSystem().displayMetrics.density).toInt()

fun Int.pxToSp() : Int = (this / Resources.getSystem().displayMetrics.scaledDensity).toInt()

fun Int.spToPx() : Int = (this * Resources.getSystem().displayMetrics.scaledDensity).toInt()
