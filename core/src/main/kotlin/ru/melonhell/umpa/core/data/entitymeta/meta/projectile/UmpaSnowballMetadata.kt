package ru.melonhell.umpa.core.data.entitymeta.meta.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaThrowableItemProjectileMetadata

open class UmpaSnowballMetadata : UmpaThrowableItemProjectileMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaSnowballMetadata {
		return super.clone() as UmpaSnowballMetadata
	}

	companion object {
		private val empty = UmpaSnowballMetadata()
	}
}
