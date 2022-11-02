package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

open class UmpaAnimalMetadata : UmpaAgeableMobMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaAnimalMetadata {
		return super.clone() as UmpaAnimalMetadata
	}

	companion object {
		private val empty = UmpaAnimalMetadata()
	}
}
