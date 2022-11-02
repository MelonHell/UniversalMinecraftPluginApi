package ru.melonhell.umpa.core.data.entitymeta.meta.other

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata

open class UmpaPrimedTntMetadata(
	var fuse: Int = 80
) : UmpaEntityMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaPrimedTntMetadata {
		return super.clone() as UmpaPrimedTntMetadata
	}

	companion object {
		private val empty = UmpaPrimedTntMetadata()
	}
}
