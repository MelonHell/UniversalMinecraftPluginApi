package ru.melonhell.umpa.core.data.entitymeta.meta.other

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.utils.UmpaBlockPos

open class UmpaFallingBlockMetadata(
	var startPos: UmpaBlockPos = UmpaBlockPos()
) : UmpaEntityMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaFallingBlockMetadata {
		return super.clone() as UmpaFallingBlockMetadata
	}

	companion object {
		private val empty = UmpaFallingBlockMetadata()
	}
}
