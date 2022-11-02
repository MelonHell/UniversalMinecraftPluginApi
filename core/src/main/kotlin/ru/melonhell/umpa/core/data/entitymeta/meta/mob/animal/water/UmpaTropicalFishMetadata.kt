package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.water

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractSchoolingFishMetadata

open class UmpaTropicalFishMetadata(
	// TODO сделать кастомайзер рыб
	var typeVariant: Int = 0
) : UmpaAbstractSchoolingFishMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaTropicalFishMetadata {
		return super.clone() as UmpaTropicalFishMetadata
	}

	companion object {
		private val empty = UmpaTropicalFishMetadata()
	}
}
