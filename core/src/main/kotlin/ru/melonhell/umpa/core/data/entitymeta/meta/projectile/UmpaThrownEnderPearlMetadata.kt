package ru.melonhell.umpa.core.data.entitymeta.meta.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaThrowableItemProjectileMetadata

open class UmpaThrownEnderPearlMetadata : UmpaThrowableItemProjectileMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaThrownEnderPearlMetadata {
		return super.clone() as UmpaThrownEnderPearlMetadata
	}

	companion object {
		private val empty = UmpaThrownEnderPearlMetadata()
	}
}
