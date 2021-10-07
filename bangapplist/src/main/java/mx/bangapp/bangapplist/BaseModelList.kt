package mx.bangapp.bangapplist

class BaseModelList<Model: Any>
{
	private val aData = ArrayList<Model>()

	fun getData() = aData

	fun add(model: Model) = aData.add(model)

	fun addAll(list: ArrayList<Model>) = aData.addAll(list)

	fun getSize() = aData.size

	fun removeAt(index: Int)
	{
		aData.removeAt(index)
	}

	operator fun get(index: Int) = aData.getOrNull(index)

	operator fun set(model: Model, index: Int)
	{
		aData[index] = model
	}

	fun indexOfFirst(predicate: (Model) -> Boolean) = aData.indexOfFirst(predicate)

	fun find(model: Model): Model?
	{
		return aData.find { it == model }
	}

	fun clear() = aData.clear()
//	fun onBindAtPosition(
//		view: HolderContract,
//		index: Int
//	)
//	{
//		get(index)?.let {
//			view.onBind(it)
//		}
//	}
}