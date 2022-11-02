package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAnimalMetadata
import ru.melonhell.umpa.core.utils.UmpaBlockPos

open class UmpaTurtleMetadata(
	var homePos: UmpaBlockPos = UmpaBlockPos(),
	var hasEgg: Boolean = false,
	var layingEgg: Boolean = false,
	var travelPos: UmpaBlockPos = UmpaBlockPos(),
	var goingHome: Boolean = false,
	var travelling: Boolean = false
) : UmpaAnimalMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaTurtleMetadata {
		return super.clone() as UmpaTurtleMetadata
	}

	companion object {
		private val empty = UmpaTurtleMetadata()
	}
}
