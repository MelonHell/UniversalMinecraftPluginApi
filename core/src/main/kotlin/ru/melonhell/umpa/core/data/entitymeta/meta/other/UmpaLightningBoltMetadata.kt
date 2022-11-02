package ru.melonhell.umpa.core.data.entitymeta.meta.other

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata

open class UmpaLightningBoltMetadata : UmpaEntityMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaLightningBoltMetadata {
		return super.clone() as UmpaLightningBoltMetadata
	}

	companion object {
		private val empty = UmpaLightningBoltMetadata()
	}
}
