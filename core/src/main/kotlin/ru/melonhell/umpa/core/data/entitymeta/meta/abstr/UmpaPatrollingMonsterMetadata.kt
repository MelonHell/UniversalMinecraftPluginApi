package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

open class UmpaPatrollingMonsterMetadata : UmpaMonsterMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaPatrollingMonsterMetadata {
		return super.clone() as UmpaPatrollingMonsterMetadata
	}

	companion object {
		private val empty = UmpaPatrollingMonsterMetadata()
	}
}
