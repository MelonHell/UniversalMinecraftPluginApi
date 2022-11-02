package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaMonsterMetadata

open class UmpaZombieMetadata(
	var baby: Boolean = false,
	var specialType: Int = 0, // UNUSED
	var drownedConversion: Boolean = false
) : UmpaMonsterMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaZombieMetadata {
		return super.clone() as UmpaZombieMetadata
	}

	companion object {
		private val empty = UmpaZombieMetadata()
	}
}
