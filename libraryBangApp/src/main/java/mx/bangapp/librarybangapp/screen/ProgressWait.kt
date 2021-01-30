package mx.bangapp.librarybangapp.screen

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import mx.bangapp.librarybangapp.R

object ProgressWait
{
	private var dialog: AlertDialog ?= null

	fun showProgressDialog(context: Context, message: String ?= ""): AlertDialog
	{
		hideProgressDialog()
		val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
		val dialogView = inflater.inflate(R.layout.dialog_progress, null).apply {
			findViewById<TextView>(R.id.tv)?.run {
				text = message
			}
		}

		val dialogBuilder = AlertDialog.Builder(context).apply {
			setView(dialogView)
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