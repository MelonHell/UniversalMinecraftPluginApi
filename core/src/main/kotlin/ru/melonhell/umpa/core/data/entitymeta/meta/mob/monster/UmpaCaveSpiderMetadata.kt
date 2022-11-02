package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster

open class UmpaCaveSpiderMetadata : UmpaSpiderMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaCaveSpiderMetadata {
		return super.clone() as UmpaCaveSpiderMetadata
	}

	companion object {
		private val empty = UmpaCaveSpiderMetadata()
	}
}
