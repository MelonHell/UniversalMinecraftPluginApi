package ru.melonhell.umpa.core.data.entitymeta.meta.other

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.wrappers.UmpaItemStack
import java.util.*

open class UmpaEyeOfEnderMetadata(
	var itemStack: Optional<UmpaItemStack> = Optional.empty()
) : UmpaEntityMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaEyeOfEnderMetadata {
		return super.clone() as UmpaEyeOfEnderMetadata
	}

	companion object {
		private val empty = UmpaEyeOfEnderMetadata()
	}
}
