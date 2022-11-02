package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

open class UmpaAbstractPiglinMetadata(
	var immuneToZombification: Boolean = false
) : UmpaMonsterMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaAbstractPiglinMetadata {
		return super.clone() as UmpaAbstractPiglinMetadata
	}

	companion object {
		private val empty = UmpaAbstractPiglinMetadata()
	}
}
