package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

open class UmpaAbstractVillagerMetadata(
	var unhappyCounter: Int = 0
) : UmpaAgeableMobMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaAbstractVillagerMetadata {
		return super.clone() as UmpaAbstractVillagerMetadata
	}

	companion object {
		private val empty = UmpaAbstractVillagerMetadata()
	}
}
