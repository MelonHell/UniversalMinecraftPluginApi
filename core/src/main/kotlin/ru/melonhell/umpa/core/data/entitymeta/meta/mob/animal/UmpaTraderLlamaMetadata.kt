package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

open class UmpaTraderLlamaMetadata : UmpaLlamaMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaTraderLlamaMetadata {
		return super.clone() as UmpaTraderLlamaMetadata
	}

	companion object {
		private val empty = UmpaTraderLlamaMetadata()
	}
}
