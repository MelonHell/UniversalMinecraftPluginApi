package ru.melonhell.umpa.core.data.entitymeta.meta.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaThrowableItemProjectileMetadata

open class UmpaThrownEggMetadata : UmpaThrowableItemProjectileMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaThrownEggMetadata {
		return super.clone() as UmpaThrownEggMetadata
	}

	companion object {
		private val empty = UmpaThrownEggMetadata()
	}
}
