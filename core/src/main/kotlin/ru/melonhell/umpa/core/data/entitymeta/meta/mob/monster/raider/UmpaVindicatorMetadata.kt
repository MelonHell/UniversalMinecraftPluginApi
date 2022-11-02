package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.raider

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractIllagerMetadata

open class UmpaVindicatorMetadata : UmpaAbstractIllagerMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaVindicatorMetadata {
		return super.clone() as UmpaVindicatorMetadata
	}

	companion object {
		private val empty = UmpaVindicatorMetadata()
	}
}
