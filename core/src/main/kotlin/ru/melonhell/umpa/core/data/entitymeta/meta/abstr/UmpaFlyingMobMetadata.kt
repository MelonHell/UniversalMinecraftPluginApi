package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

open class UmpaFlyingMobMetadata : UmpaMobMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaFlyingMobMetadata {
		return super.clone() as UmpaFlyingMobMetadata
	}

	companion object {
		private val empty = UmpaFlyingMobMetadata()
	}
}
