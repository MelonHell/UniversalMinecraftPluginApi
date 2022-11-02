package ru.melonhell.umpa.core.data.entitymeta.meta.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaThrowableItemProjectileMetadata

open class UmpaThrownPotionMetadata : UmpaThrowableItemProjectileMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaThrownPotionMetadata {
		return super.clone() as UmpaThrownPotionMetadata
	}

	companion object {
		private val empty = UmpaThrownPotionMetadata()
	}
}
