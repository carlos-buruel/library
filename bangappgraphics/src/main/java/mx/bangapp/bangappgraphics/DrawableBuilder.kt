package mx.bangapp.bangappgraphics

import android.graphics.drawable.GradientDrawable

object DrawableBuilder
{
	fun setRectangleGradient(
		rectangleColor: Int,
		iCornerRadius: Float = 0f,
		iWidthRadius: Int = 0,
		strokeColor: Int = 0
	) = GradientDrawable().apply {
		shape = GradientDrawable.RECTANGLE
		setColor(rectangleColor)
		if (iCornerRadius != 0f)
			cornerRadius = iCornerRadius
		if (iWidthRadius != 0 && strokeColor != 0)
			setStroke(iWidthRadius, strokeColor)
	}

	/**
	 * Each pair is a corner on
	 * @param aCornerRadius: corners for RECTANGLE
	 * 1 - Top left
	 * 2 - Top right
	 * 3 - Bottom right
	 * 4 - Bottom left
	 */
	fun setRectangleGradient(
		colorBase: Int,
		aCornerRadius: FloatArray = floatArrayOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f),
		iWidthRadius: Int = 0,
		strokeColor: Int = 0): GradientDrawable
	{
		return GradientDrawable().apply {
			shape = GradientDrawable.RECTANGLE
			setColor(colorBase)
			cornerRadii = aCornerRadius
			if (iWidthRadius != 0 && strokeColor != 0)
				setStroke(iWidthRadius, strokeColor)
		}
	}
}