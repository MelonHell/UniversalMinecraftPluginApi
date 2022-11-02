package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAnimalMetadata

open class UmpaOcelotMetadata(
	var trusting: Boolean = false
) : UmpaAnimalMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaOcelotMetadata {
		return super.clone() as UmpaOcelotMetadata
	}

	companion object {
		private val empty = UmpaOcelotMetadata()
	}
}
