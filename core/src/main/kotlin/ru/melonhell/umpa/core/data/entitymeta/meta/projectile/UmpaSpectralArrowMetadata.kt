package ru.melonhell.umpa.core.data.entitymeta.meta.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractArrowMetadata

open class UmpaSpectralArrowMetadata : UmpaAbstractArrowMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaSpectralArrowMetadata {
		return super.clone() as UmpaSpectralArrowMetadata
	}

	companion object {
		private val empty = UmpaSpectralArrowMetadata()
	}
}
