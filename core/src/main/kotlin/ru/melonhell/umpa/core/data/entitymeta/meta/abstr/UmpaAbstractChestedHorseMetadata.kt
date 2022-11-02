package ru.melonhell.umpa.core.data.entitymeta.meta.abstr
		
open class UmpaAbstractChestedHorseMetadata(
	var hasChest: Boolean = false
) : UmpaAbstractHorseMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaAbstractChestedHorseMetadata {
		return super.clone() as UmpaAbstractChestedHorseMetadata
	}

	companion object {
		private val empty = UmpaAbstractChestedHorseMetadata()
	}
}
