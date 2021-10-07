package mx.bangapp.bangappgraphics

import android.content.Context
import androidx.core.content.ContextCompat

fun Context.getParseColor(intRes: Int) = ContextCompat.getColor(this, intRes)