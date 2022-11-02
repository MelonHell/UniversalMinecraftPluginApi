package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

import ru.melonhell.umpa.core.wrappers.UmpaItemStack
import java.util.*

open class UmpaFireballMetadata(
	var itemStack: Optional<UmpaItemStack> = Optional.empty()
) : UmpaAbstractHurtingProjectileMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaFireballMetadata {
		return super.clone() as UmpaFireballMetadata
	}

	companion object {
		private val empty = UmpaFireballMetadata()
	}
}
