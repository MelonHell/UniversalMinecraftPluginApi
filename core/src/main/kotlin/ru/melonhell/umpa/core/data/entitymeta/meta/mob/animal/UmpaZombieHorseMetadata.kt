package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractHorseMetadata

open class UmpaZombieHorseMetadata : UmpaAbstractHorseMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaZombieHorseMetadata {
		return super.clone() as UmpaZombieHorseMetadata
	}

	companion object {
		private val empty = UmpaZombieHorseMetadata()
	}
}
