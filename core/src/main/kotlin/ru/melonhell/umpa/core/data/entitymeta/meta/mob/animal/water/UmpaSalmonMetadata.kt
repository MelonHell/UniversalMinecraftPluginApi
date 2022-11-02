package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.water

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractSchoolingFishMetadata

open class UmpaSalmonMetadata : UmpaAbstractSchoolingFishMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaSalmonMetadata {
		return super.clone() as UmpaSalmonMetadata
	}

	companion object {
		private val empty = UmpaSalmonMetadata()
	}
}
