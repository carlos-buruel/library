package mx.bangapp.librarybangapp.list

import androidx.recyclerview.widget.RecyclerView
import mx.bangapp.librarybangapp.holder.Holder
import mx.bangapp.librarybangapp.interfaces.OnItemClickListener

abstract class BaseAdapter(
	private val model: BaseModelList<*>,
	private val listener: OnItemClickListener? = null
) :RecyclerView.Adapter<Holder>()
{
	override fun onBindViewHolder(holder: Holder, position: Int)
	{
		with(holder)
		{
			onPaint()
			model.onBindAtPosition(this, position, listener)
		}
	}

	override fun getItemCount(): Int
	{
		return model.countData()
	}
}