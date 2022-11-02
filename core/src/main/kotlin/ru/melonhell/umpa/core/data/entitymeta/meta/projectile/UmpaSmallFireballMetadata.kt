package ru.melonhell.umpa.core.data.entitymeta.meta.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaFireballMetadata

open class UmpaSmallFireballMetadata : UmpaFireballMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaSmallFireballMetadata {
		return super.clone() as UmpaSmallFireballMetadata
	}

	companion object {
		private val empty = UmpaSmallFireballMetadata()
	}
}
