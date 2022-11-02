package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAnimalMetadata

open class UmpaStriderMetadata(
	var boostTime: Int = 0,
	var suffocating: Boolean = false,
	var saddle: Boolean = false
) : UmpaAnimalMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaStriderMetadata {
		return super.clone() as UmpaStriderMetadata
	}

	companion object {
		private val empty = UmpaStriderMetadata()
	}
}
