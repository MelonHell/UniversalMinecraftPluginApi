package ru.melonhell.umpa.core.data.entitymeta.meta.other

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaHangingEntityMetadata

open class UmpaLeashKnotMetadata : UmpaHangingEntityMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaLeashKnotMetadata {
		return super.clone() as UmpaLeashKnotMetadata
	}

	companion object {
		private val empty = UmpaLeashKnotMetadata()
	}
}
