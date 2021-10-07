package mx.bangapp.bangappview

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import mx.bangapp.bangappgraphics.DrawableBuilder
import mx.bangapp.bangappgraphics.getParseColor
import mx.bangapp.bangappmetrics.dpToPx

class ProgressBarBA(context: Context): RelativeLayout(context)
{
	private var vBase: View
	private var vProgress: View
	private var tvFirstText: TextView
	private var tvSecondText: TextView

	private var minHeight = 32f

	init {
		layoutParams = LayoutParams(-1, dpToPx(minHeight))
		//region colors container
		val llBaseColors = RelativeLayout(context).apply {
			layoutParams = LayoutParams(-1, -1)

			vBase = View(context).apply {
				layoutParams = LayoutParams(-1, -1)
				setBackgroundColor(Color.YELLOW)
			}
			setBaseColor(R.color.purple_700)
			addView(vBase)
			vProgress = View(context).apply {
				layoutParams = LayoutParams(dpToPx(100f), -1)
				setBackgroundColor(Color.RED)
			}
			setProgressColor(R.color.purple_200)
			addView(vProgress)
		}
		addView(llBaseColors)
		//endregion
		//region text container
		val llBaseText = LinearLayout(context).apply {
			layoutParams = LayoutParams(-1, -1).apply { weightSum = 2f }

			tvFirstText = TextView(context).apply {
				gravity = Gravity.START or(Gravity.CENTER)
				layoutParams = LinearLayout.LayoutParams(0, -2).apply { weight = 1f }
			}
			setFirstTextColor(R.color.white)
			setFirstContent("2/4 Objetivos completados")
			addView(tvFirstText)

			tvSecondText = TextView(context).apply {
				gravity = Gravity.END or(Gravity.CENTER)
				layoutParams = LinearLayout.LayoutParams(0, -2).apply { weight = 1f }
			}
			setSecondTextColor(R.color.white)
			setSecondContent("⏰ 8 días 22 horas")
			addView(tvSecondText)
		}
		addView(llBaseText)
		//endregion
	}

	@Suppress("unused")
	fun setBaseColor(intColor: Int)
	{
		val color = context.getParseColor(intColor)
		vBase.background = DrawableBuilder.setRectangleGradient(color, 15f)
	}

	@Suppress("unused")
	fun setProgressColor(intColor: Int)
	{
		val color = context.getParseColor(intColor)
		vProgress.background = DrawableBuilder.setRectangleGradient(
			color,
			floatArrayOf(15f, 15f, 0f, 0f, 0f, 0f, 15f, 15f)
		)
	}

	@Suppress("unused")
	fun setFirstTextColor(intColor: Int)
	{
		val color = context.getParseColor(intColor)
		tvFirstText.setTextColor(color)
	}

	@Suppress("unused")
	fun setSecondTextColor(intColor: Int)
	{
		val color = context.getParseColor(intColor)
		tvSecondText.setTextColor(color)
	}

	@Suppress("unused")
	fun setFirstContent(text: String)
	{
		tvFirstText.text = text
	}

	@Suppress("unused")
	fun setSecondContent(text: String)
	{
		tvSecondText.text = text
	}
}