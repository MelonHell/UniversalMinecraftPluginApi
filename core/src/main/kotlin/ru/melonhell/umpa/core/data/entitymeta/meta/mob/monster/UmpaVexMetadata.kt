package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaMonsterMetadata

open class UmpaVexMetadata(
	var attacking: Boolean = false
) : UmpaMonsterMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaVexMetadata {
		return super.clone() as UmpaVexMetadata
	}

	companion object {
		private val empty = UmpaVexMetadata()
	}
}
