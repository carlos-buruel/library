package mx.bangapp.librarybangapp.holder

import mx.bangapp.librarybangapp.interfaces.OnItemClickListener

interface HolderContract
{
	fun onPaint()
	fun onBind(item: Any? = null, listener: OnItemClickListener? = null)
}