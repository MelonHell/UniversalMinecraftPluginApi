package ru.melonhell.umpa.core.data.entitymeta.meta.other

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata

open class UmpaEvokerFangsMetadata : UmpaEntityMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaEvokerFangsMetadata {
		return super.clone() as UmpaEvokerFangsMetadata
	}

	companion object {
		private val empty = UmpaEvokerFangsMetadata()
	}
}
