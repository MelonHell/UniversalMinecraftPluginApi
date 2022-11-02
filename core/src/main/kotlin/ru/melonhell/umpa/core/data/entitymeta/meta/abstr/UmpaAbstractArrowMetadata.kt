package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

open class UmpaAbstractArrowMetadata(
	var critical: Boolean = false,
	var noclip: Boolean = false,
	var pierceLevel: Byte = 0
) : UmpaProjectileMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaAbstractArrowMetadata {
		return super.clone() as UmpaAbstractArrowMetadata
	}

	companion object {
		private val empty = UmpaAbstractArrowMetadata()
	}
}
