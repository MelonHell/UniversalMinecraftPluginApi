package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

open class UmpaMonsterMetadata : UmpaPathfinderMobMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaMonsterMetadata {
		return super.clone() as UmpaMonsterMetadata
	}

	companion object {
		private val empty = UmpaMonsterMetadata()
	}
}
