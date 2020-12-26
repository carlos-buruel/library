package mx.bangapp.librarybangapp.list

import mx.bangapp.librarybangapp.holder.HolderContract
import mx.bangapp.librarybangapp.interfaces.OnItemClickListener

open class BaseModelList<Model: Any>
{
	private val aData = ArrayList<Model>()

	fun getData() = aData

	fun add(data: Model)
	{
		aData.add(data)
	}

	fun addAll(aData: ArrayList<Model>)
	{
		this.aData.addAll(aData)
	}

	fun clear()
	{
		aData.clear()
	}

	fun removeAt(index: Int)
	{
		aData.removeAt(index)
	}

	fun indexOfFirst(predicate: (Model) -> Boolean): Int
	{
		return aData.indexOfFirst(predicate)
	}

	open fun countData() = aData.size

	operator fun get(position: Int): Model?
	{
		return if (position < aData.size)
		{
			aData[position]
		}
		else null
	}

	open fun onBindAtPosition(
		view: HolderContract,
		position: Int,
		listener: OnItemClickListener ?= null
	)
	{
		get(position)?.let {
			view.onBind(it, listener)
		}
	}
}