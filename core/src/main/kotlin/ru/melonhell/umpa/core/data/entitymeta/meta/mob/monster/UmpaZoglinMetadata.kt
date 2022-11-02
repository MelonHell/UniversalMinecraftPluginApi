package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaMonsterMetadata

open class UmpaZoglinMetadata(
	var baby: Boolean = false
) : UmpaMonsterMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaZoglinMetadata {
		return super.clone() as UmpaZoglinMetadata
	}

	companion object {
		private val empty = UmpaZoglinMetadata()
	}
}
