package ru.melonhell.umpa.core.data.entitymeta.meta.other

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.wrappers.UmpaItemStack
import java.util.*

open class UmpaItemEntityMetadata(
	var item: Optional<UmpaItemStack> = Optional.empty()
) : UmpaEntityMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaItemEntityMetadata {
		return super.clone() as UmpaItemEntityMetadata
	}

	companion object {
		private val empty = UmpaItemEntityMetadata()
	}
}
