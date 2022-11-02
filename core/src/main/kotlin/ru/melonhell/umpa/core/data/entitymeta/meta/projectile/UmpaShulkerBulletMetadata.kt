package ru.melonhell.umpa.core.data.entitymeta.meta.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaProjectileMetadata

open class UmpaShulkerBulletMetadata : UmpaProjectileMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaShulkerBulletMetadata {
		return super.clone() as UmpaShulkerBulletMetadata
	}

	companion object {
		private val empty = UmpaShulkerBulletMetadata()
	}
}
