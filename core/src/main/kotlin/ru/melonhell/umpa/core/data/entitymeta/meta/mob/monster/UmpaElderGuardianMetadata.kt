package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster

open class UmpaElderGuardianMetadata : UmpaGuardianMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaElderGuardianMetadata {
		return super.clone() as UmpaElderGuardianMetadata
	}

	companion object {
		private val empty = UmpaElderGuardianMetadata()
	}
}
