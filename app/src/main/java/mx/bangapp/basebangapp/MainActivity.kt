package mx.bangapp.basebangapp

import mx.bangapp.bangappactivity.ListActivity
import mx.bangapp.bangapplist.BaseAdapter
import mx.bangapp.bangapplist.BaseModelList
import mx.bangapp.bangappview.ProgressBarBA

class MainActivity: ListActivity()
{
	override fun initViews()
	{
		val model = BaseModelList<String>()
		model.add("1")
		model.add("1")
		model.add("1")
		model.add("1")
		val adapter = BaseAdapter(model) {
			ProgressBarBA(this@MainActivity).apply {
				//setContentText1("")
			}
		}
		setAdapter(adapter)
	}
}