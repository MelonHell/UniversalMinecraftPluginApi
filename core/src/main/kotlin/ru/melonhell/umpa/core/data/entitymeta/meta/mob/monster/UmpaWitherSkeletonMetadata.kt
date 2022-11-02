package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractSkeletonMetadata

open class UmpaWitherSkeletonMetadata : UmpaAbstractSkeletonMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaWitherSkeletonMetadata {
		return super.clone() as UmpaWitherSkeletonMetadata
	}

	companion object {
		private val empty = UmpaWitherSkeletonMetadata()
	}
}
