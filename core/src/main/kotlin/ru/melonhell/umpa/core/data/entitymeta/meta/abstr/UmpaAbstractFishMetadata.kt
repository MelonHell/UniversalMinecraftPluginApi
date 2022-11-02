package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

open class UmpaAbstractFishMetadata(
	var fromBucket: Boolean = false
) : UmpaWaterAnimalMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaAbstractFishMetadata {
		return super.clone() as UmpaAbstractFishMetadata
	}

	companion object {
		private val empty = UmpaAbstractFishMetadata()
	}
}
