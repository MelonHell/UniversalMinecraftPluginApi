package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractSkeletonMetadata

open class UmpaStrayMetadata : UmpaAbstractSkeletonMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaStrayMetadata {
		return super.clone() as UmpaStrayMetadata
	}

	companion object {
		private val empty = UmpaStrayMetadata()
	}
}
