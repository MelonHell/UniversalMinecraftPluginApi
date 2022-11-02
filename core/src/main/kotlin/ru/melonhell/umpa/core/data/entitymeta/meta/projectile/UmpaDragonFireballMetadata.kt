package ru.melonhell.umpa.core.data.entitymeta.meta.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractHurtingProjectileMetadata

open class UmpaDragonFireballMetadata : UmpaAbstractHurtingProjectileMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaDragonFireballMetadata {
		return super.clone() as UmpaDragonFireballMetadata
	}

	companion object {
		private val empty = UmpaDragonFireballMetadata()
	}
}
