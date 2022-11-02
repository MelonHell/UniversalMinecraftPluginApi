package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaMonsterMetadata

open class UmpaWitherBossMetadata(
	var centerHeadTargetId: Int = 0,
	var leftHeadTargetId: Int = 0,
	var rightHeadTargetId: Int = 0,
	var invulnerableTime: Int = 0
) : UmpaMonsterMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaWitherBossMetadata {
		return super.clone() as UmpaWitherBossMetadata
	}

	companion object {
		private val empty = UmpaWitherBossMetadata()
	}
}
