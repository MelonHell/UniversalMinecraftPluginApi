package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

open class UmpaThrowableProjectileMetadata : UmpaProjectileMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaThrowableProjectileMetadata {
		return super.clone() as UmpaThrowableProjectileMetadata
	}

	companion object {
		private val empty = UmpaThrowableProjectileMetadata()
	}
}
