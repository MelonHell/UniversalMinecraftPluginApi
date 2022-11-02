package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.raider

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaRaiderMetadata

open class UmpaRavagerMetadata : UmpaRaiderMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaRavagerMetadata {
		return super.clone() as UmpaRavagerMetadata
	}

	companion object {
		private val empty = UmpaRavagerMetadata()
	}
}
