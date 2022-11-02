package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.water

open class UmpaGlowSquidMetadata(
	var darkTicksRemaining: Int = 0
) : UmpaSquidMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaGlowSquidMetadata {
		return super.clone() as UmpaGlowSquidMetadata
	}

	companion object {
		private val empty = UmpaGlowSquidMetadata()
	}
}
