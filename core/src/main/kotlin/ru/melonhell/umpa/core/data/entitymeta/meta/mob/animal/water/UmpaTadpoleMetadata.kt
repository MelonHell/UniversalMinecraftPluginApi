package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.water

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractFishMetadata

open class UmpaTadpoleMetadata : UmpaAbstractFishMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaTadpoleMetadata {
		return super.clone() as UmpaTadpoleMetadata
	}

	companion object {
		private val empty = UmpaTadpoleMetadata()
	}
}
