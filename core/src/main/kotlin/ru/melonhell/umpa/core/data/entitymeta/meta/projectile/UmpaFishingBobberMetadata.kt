package ru.melonhell.umpa.core.data.entitymeta.meta.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaProjectileMetadata

open class UmpaFishingBobberMetadata(
	var hookedEntityId: Int = 0,
	var biting: Boolean = false
) : UmpaProjectileMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaFishingBobberMetadata {
		return super.clone() as UmpaFishingBobberMetadata
	}

	companion object {
		private val empty = UmpaFishingBobberMetadata()
	}
}
