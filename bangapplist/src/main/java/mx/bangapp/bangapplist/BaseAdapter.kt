package mx.bangapp.bangapplist

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

open class BaseAdapter(
	private val model: BaseModelList<*>,
	private val getView: () -> View
): RecyclerView.Adapter<Holder>()
{
	override fun getItemCount() = model.getSize()

	override fun onBindViewHolder(holder: Holder, position: Int)
	{
		model[position]?.let {
			holder.onBind(it)
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder
	{
		return BaseHolder(getView())
	}
}