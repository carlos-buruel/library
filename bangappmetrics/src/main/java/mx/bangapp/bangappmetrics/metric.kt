package mx.bangapp.bangappmetrics

import android.content.Context
import android.util.TypedValue
import android.view.View

fun Context.dpToPx(dp: Float): Int = TypedValue.applyDimension(
	TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics).toInt()

fun View.dpToPx(dp: Float): Int = context.dpToPx(dp)