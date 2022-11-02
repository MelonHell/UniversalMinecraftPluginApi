package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

open class UmpaAmbientCreatureMetadata : UmpaMobMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaAmbientCreatureMetadata {
		return super.clone() as UmpaAmbientCreatureMetadata
	}

	companion object {
		private val empty = UmpaAmbientCreatureMetadata()
	}
}
