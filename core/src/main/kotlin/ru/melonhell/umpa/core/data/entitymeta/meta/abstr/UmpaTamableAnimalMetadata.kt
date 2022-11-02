package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

import java.util.*

open class UmpaTamableAnimalMetadata(
	var sitting: Boolean = false,
	var tamed: Boolean = false,
	var ownerUuid: Optional<UUID> = Optional.empty()
) : UmpaAnimalMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaTamableAnimalMetadata {
		return super.clone() as UmpaTamableAnimalMetadata
	}

	companion object {
		private val empty = UmpaTamableAnimalMetadata()
	}
}
