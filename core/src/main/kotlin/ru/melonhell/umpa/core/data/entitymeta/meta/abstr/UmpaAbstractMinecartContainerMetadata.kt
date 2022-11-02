package ru.melonhell.umpa.core.data.entitymeta.meta.abstr
		
open class UmpaAbstractMinecartContainerMetadata : UmpaAbstractMinecartMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaAbstractMinecartContainerMetadata {
		return super.clone() as UmpaAbstractMinecartContainerMetadata
	}

	companion object {
		private val empty = UmpaAbstractMinecartContainerMetadata()
	}
}
