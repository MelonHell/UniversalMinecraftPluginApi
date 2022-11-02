package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.raider

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaSpellcasterIllagerMetadata

open class UmpaIllusionerMetadata : UmpaSpellcasterIllagerMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaIllusionerMetadata {
		return super.clone() as UmpaIllusionerMetadata
	}

	companion object {
		private val empty = UmpaIllusionerMetadata()
	}
}
