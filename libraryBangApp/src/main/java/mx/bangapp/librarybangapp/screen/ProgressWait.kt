package mx.bangapp.librarybangapp.screen

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TableRow
import androidx.appcompat.app.AlertDialog
import mx.bangapp.librarybangapp.CustomGradient
import mx.bangapp.librarybangapp.R
import mx.bangapp.librarybangapp.constant.Variable.MATCH_PARENT
import mx.bangapp.librarybangapp.constant.Variable.WRAP_CONTENT
import mx.bangapp.librarybangapp.extension.dpToPx
import mx.bangapp.librarybangapp.extension.margin
import mx.bangapp.librarybangapp.extension.marginAll

object ProgressWait
{
	private var dialog: AlertDialog ?= null

	fun showProgressDialog(context: Context/*, message: String ?= ""*/): AlertDialog
	{
		hideProgressDialog()

		val rlMain = RelativeLayout(context).apply {
			layoutParams = RelativeLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
			background = CustomGradient.setGradientDrawable(Color.TRANSPARENT, 0f)
			//region TableRow
			val tr = TableRow(context).apply {
				layoutParams = RelativeLayout.LayoutParams(WRAP_CONTENT, dpToPx(64f)).apply {
					addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE)
				}
				background = CustomGradient.setGradientDrawable(Color.WHITE, 0f)
				marginAll(30f)
				//region ProgressBar
				addView(
					ProgressBar(context).apply {
						id = R.id.pb
						layoutParams = TableRow.LayoutParams(WRAP_CONTENT, MATCH_PARENT)
						margin(start = 10f,end = 10f)
					}
				)
//				addView(
//					TextView(context).apply {
//						id = R.id.tv
//						layoutParams = TableRow.LayoutParams(MATCH_PARENT, MATCH_PARENT)
//						setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
//						setTextColor(Color.BLACK)
//					}
//				)
				//endregion
			}
			//endregion
			addView(tr)
		}
//		val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//		val dialogView = inflater.inflate(R.layout.dialog_progress, nullContainer).apply {
//			findViewById<TextView>(R.id.tv)?.run {
//				text = message
//			}
//		}
		val dialogBuilder = AlertDialog.Builder(context).apply {
			setView(rlMain)
			setCancelable(false)
		}

		return dialogBuilder.create().apply {
			dialog = this
			window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
			show()
		}
	}

	fun hideProgressDialog()
	{
		dialog?.dismiss()
	}
}