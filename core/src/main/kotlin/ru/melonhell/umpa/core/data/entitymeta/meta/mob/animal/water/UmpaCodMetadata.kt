package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.water

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractSchoolingFishMetadata

open class UmpaCodMetadata : UmpaAbstractSchoolingFishMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaCodMetadata {
		return super.clone() as UmpaCodMetadata
	}

	companion object {
		private val empty = UmpaCodMetadata()
	}
}
