package ru.melonhell.umpa.core.data.entitymeta.meta.mob

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractGolemMetadata

open class UmpaSnowGolemMetadata(
	var pumpkin: Boolean = true
) : UmpaAbstractGolemMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaSnowGolemMetadata {
		return super.clone() as UmpaSnowGolemMetadata
	}

	companion object {
		private val empty = UmpaSnowGolemMetadata()
	}
}
