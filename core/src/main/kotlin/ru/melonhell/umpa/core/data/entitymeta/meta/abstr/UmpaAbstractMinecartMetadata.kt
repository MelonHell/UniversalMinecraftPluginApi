package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata

open class UmpaAbstractMinecartMetadata(
	var hurt: Int = 0,
	var hurtdir: Int = 1,
	var damage: Float = 0.0F,
	var displayBlock: Int = 0,
	var displayOffset: Int = 6,
	var customDisplay: Boolean = false
) : UmpaEntityMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaAbstractMinecartMetadata {
		return super.clone() as UmpaAbstractMinecartMetadata
	}

	companion object {
		private val empty = UmpaAbstractMinecartMetadata()
	}
}
