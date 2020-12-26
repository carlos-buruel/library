package mx.bangapp.librarybangapp.screen

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.ViewGroup

abstract class BaseDialog(
	context: Context,
	private val intRest: Int,
	private val isFull: Boolean = true): Dialog(context)
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setCanceledOnTouchOutside(false)
		setContentView(intRest)
		window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
			if (isFull) ViewGroup.LayoutParams.MATCH_PARENT else ViewGroup.LayoutParams.WRAP_CONTENT)
		onCreateView()
	}

	open fun onCreateView()
	{
		setViews()
	}

	abstract fun setViews()
}