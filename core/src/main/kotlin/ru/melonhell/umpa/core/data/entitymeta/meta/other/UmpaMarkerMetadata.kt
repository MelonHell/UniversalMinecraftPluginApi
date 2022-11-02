package ru.melonhell.umpa.core.data.entitymeta.meta.other

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata

open class UmpaMarkerMetadata : UmpaEntityMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaMarkerMetadata {
		return super.clone() as UmpaMarkerMetadata
	}

	companion object {
		private val empty = UmpaMarkerMetadata()
	}
}
