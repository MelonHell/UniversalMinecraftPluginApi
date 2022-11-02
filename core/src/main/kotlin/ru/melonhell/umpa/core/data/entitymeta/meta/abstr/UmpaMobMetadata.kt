package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

open class UmpaMobMetadata(
	var noAi: Boolean = false,
	var leftHanded: Boolean = false,
	var aggressive: Boolean = false,
) : UmpaLivingEntityMetadata() {
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaMobMetadata {
		return super.clone() as UmpaMobMetadata
	}

	companion object {
		private val empty = UmpaMobMetadata()
	}
}