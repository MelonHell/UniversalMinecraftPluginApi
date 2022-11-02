package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAnimalMetadata

open class UmpaBeeMetadata(
	var angry: Boolean = false,
	var hasStung: Boolean = false,
	var hasNectar: Boolean = false,
	var remainingAngerTime: Int = 0
) : UmpaAnimalMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaBeeMetadata {
		return super.clone() as UmpaBeeMetadata
	}

	companion object {
		private val empty = UmpaBeeMetadata()
	}
}
