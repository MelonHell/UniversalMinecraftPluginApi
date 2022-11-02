package ru.melonhell.umpa.core.data.entitymeta.meta.other

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractMinecartContainerMetadata

open class UmpaMinecartHopperMetadata : UmpaAbstractMinecartContainerMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaMinecartHopperMetadata {
		return super.clone() as UmpaMinecartHopperMetadata
	}

	companion object {
		private val empty = UmpaMinecartHopperMetadata()
	}
}
