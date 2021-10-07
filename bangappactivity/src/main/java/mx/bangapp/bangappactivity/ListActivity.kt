package mx.bangapp.bangappactivity

import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mx.bangapp.bangapplist.BaseAdapter

/**
 * Activity LIST
 */
abstract class ListActivity: BaseActivity()
{
	private lateinit var rvMain: RecyclerView
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		rvMain = RecyclerView(this).apply {
			layoutParams = ViewGroup.LayoutParams(-1,-1)
			id = R.id.rvMain
		}
		setContentView(rvMain)
		initViews()
	}

	fun setAdapter(baseAdapter: BaseAdapter)
	{
		rvMain.run {
			adapter = baseAdapter
			layoutManager = LinearLayoutManager(this@ListActivity)
		}
	}
}