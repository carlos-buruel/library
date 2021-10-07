package mx.bangapp.bangappmetrics

import android.view.View
import android.view.ViewGroup

fun View.margin(
	start: Float? = null,
	top: Float? = null,
	end: Float? = null,
	bottom: Float? = null)
{
	(layoutParams as? ViewGroup.MarginLayoutParams)?.run {
		start?.let { marginStart = dpToPx(it) }
		top?.let { topMargin = dpToPx(it) }
		end?.let { marginEnd = dpToPx(it) }
		bottom?.let { bottomMargin = dpToPx(it) }
	}
}

fun View.marginAll(margin: Float)
{
	margin(margin)
}

fun View.padding(
	start: Float? = null,
	top: Float? = null,
	end: Float? = null,
	bottom: Float? = null)
{
	setPadding(
		start?.let { dpToPx(it) } ?: 0,
		top?.let { dpToPx(it) } ?: 0,
		end?.let { dpToPx(it) } ?: 0,
		bottom?.let { dpToPx(it) } ?: 0
	)
}