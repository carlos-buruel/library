package mx.bangapp.librarybangapp.screen

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity(intRes: Int): AppCompatActivity(intRes)
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		onCreateView()
		initData()
		initListener()
		setList()
	}

	fun hideKeyboard()
	{
		currentFocus?.let {
			val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
			imm.hideSoftInputFromWindow(it.windowToken, 0)
		}
	}

	open fun onCreateView() {}
	open fun initData() {}
	open fun setList() {}
	open fun initListener() {}

	open fun showDialog()
	{
		ProgressWait.showProgressDialog(this)
	}

	open fun hideDialog()
	{
		ProgressWait.hideProgressDialog()
	}
}