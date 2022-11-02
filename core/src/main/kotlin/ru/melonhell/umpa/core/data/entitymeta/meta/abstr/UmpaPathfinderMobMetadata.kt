package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

open class UmpaPathfinderMobMetadata : UmpaMobMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaPathfinderMobMetadata {
		return super.clone() as UmpaPathfinderMobMetadata
	}

	companion object {
		private val empty = UmpaPathfinderMobMetadata()
	}
}
