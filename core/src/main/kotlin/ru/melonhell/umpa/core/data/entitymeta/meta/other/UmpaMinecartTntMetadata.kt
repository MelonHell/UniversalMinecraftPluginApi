package ru.melonhell.umpa.core.data.entitymeta.meta.other

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractMinecartMetadata

open class UmpaMinecartTntMetadata : UmpaAbstractMinecartMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaMinecartTntMetadata {
		return super.clone() as UmpaMinecartTntMetadata
	}

	companion object {
		private val empty = UmpaMinecartTntMetadata()
	}
}
