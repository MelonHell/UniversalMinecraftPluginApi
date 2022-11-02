package ru.melonhell.umpa.core.data.entitymeta.meta.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractArrowMetadata

open class UmpaThrownTridentMetadata(
	var loyaltyLevel: Byte = 0,
	var hasEnchantmentGlint: Boolean = false
) : UmpaAbstractArrowMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaThrownTridentMetadata {
		return super.clone() as UmpaThrownTridentMetadata
	}

	companion object {
		private val empty = UmpaThrownTridentMetadata()
	}
}
