package mx.bangapp.testapp

import mx.bangapp.librarybangapp.screen.BaseActivity

class MainActivity : BaseActivity(R.layout.activity_main)
{
	override fun onCreateView()
	{
		super.onCreateView()
		showDialog()
	}
}