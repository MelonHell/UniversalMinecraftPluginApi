package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAnimalMetadata

open class UmpaChickenMetadata : UmpaAnimalMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaChickenMetadata {
		return super.clone() as UmpaChickenMetadata
	}

	companion object {
		private val empty = UmpaChickenMetadata()
	}
}
