package ru.melonhell.umpa.core.data.entitymeta.meta.other

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaHangingEntityMetadata
import ru.melonhell.umpa.core.wrappers.UmpaItemStack
import java.util.*

open class UmpaItemFrameMetadata(
	var item: Optional<UmpaItemStack> = Optional.empty(),
	var itemRotation: Int = 0
) : UmpaHangingEntityMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaItemFrameMetadata {
		return super.clone() as UmpaItemFrameMetadata
	}

	companion object {
		private val empty = UmpaItemFrameMetadata()
	}
}
