package ru.melonhell.umpa.core.data.entitymeta.meta.mob

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaFlyingMobMetadata

open class UmpaGhastMetadata(
	var attacking: Boolean = false
) : UmpaFlyingMobMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaGhastMetadata {
		return super.clone() as UmpaGhastMetadata
	}

	companion object {
		private val empty = UmpaGhastMetadata()
	}
}
