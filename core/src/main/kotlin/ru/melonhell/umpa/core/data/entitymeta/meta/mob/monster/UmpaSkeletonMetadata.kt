package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractSkeletonMetadata

open class UmpaSkeletonMetadata(
	var strayConversion: Boolean = false
) : UmpaAbstractSkeletonMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaSkeletonMetadata {
		return super.clone() as UmpaSkeletonMetadata
	}

	companion object {
		private val empty = UmpaSkeletonMetadata()
	}
}
