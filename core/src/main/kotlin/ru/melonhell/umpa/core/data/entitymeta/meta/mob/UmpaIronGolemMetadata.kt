package ru.melonhell.umpa.core.data.entitymeta.meta.mob

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractGolemMetadata

open class UmpaIronGolemMetadata(
	var playerCreated: Boolean = false
) : UmpaAbstractGolemMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaIronGolemMetadata {
		return super.clone() as UmpaIronGolemMetadata
	}

	companion object {
		private val empty = UmpaIronGolemMetadata()
	}
}
