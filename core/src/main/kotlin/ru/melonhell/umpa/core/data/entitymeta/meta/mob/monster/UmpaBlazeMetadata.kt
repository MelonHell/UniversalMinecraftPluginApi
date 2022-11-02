package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaMonsterMetadata

open class UmpaBlazeMetadata(
	var blazeOnFire: Boolean = false
) : UmpaMonsterMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaBlazeMetadata {
		return super.clone() as UmpaBlazeMetadata
	}

	companion object {
		private val empty = UmpaBlazeMetadata()
	}
}
