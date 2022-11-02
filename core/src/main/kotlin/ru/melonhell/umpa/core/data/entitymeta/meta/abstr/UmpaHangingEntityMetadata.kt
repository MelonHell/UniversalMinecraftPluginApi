package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata

open class UmpaHangingEntityMetadata : UmpaEntityMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaHangingEntityMetadata {
		return super.clone() as UmpaHangingEntityMetadata
	}

	companion object {
		private val empty = UmpaHangingEntityMetadata()
	}
}
