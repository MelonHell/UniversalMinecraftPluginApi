package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAnimalMetadata

open class UmpaGoatMetadata(
	var screaming: Boolean = false,
	var hasLeftHorn: Boolean = true,
	var hasRightHorn: Boolean = true
) : UmpaAnimalMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaGoatMetadata {
		return super.clone() as UmpaGoatMetadata
	}

	companion object {
		private val empty = UmpaGoatMetadata()
	}
}
