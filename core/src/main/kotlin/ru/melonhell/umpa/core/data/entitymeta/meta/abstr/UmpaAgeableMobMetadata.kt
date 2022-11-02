package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

open class UmpaAgeableMobMetadata(
	var baby: Boolean = false
) : UmpaPathfinderMobMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaAgeableMobMetadata {
		return super.clone() as UmpaAgeableMobMetadata
	}

	companion object {
		private val empty = UmpaAgeableMobMetadata()
	}
}
