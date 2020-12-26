package mx.bangapp.librarybangapp.screen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment()
{
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View?
	{
		return arguments?.let {
			val iLayout = it.getInt("LAYOUT", 0)
			val view = inflater.inflate(iLayout, container, false)
			onRenderViews(view)
			view
		} ?: run { null }
	}

	open fun onRenderViews(view: View)
	{
		initViews(view)
		initListener()
	}

	fun hideKeyboard()
	{
		activity?.let {
			(it.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)
				?.hideSoftInputFromWindow(view?.windowToken, 0)
		}
	}

	abstract fun initViews(view: View)
	abstract fun initListener()
}