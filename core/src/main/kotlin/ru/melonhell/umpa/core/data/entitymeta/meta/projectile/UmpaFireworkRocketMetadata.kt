package ru.melonhell.umpa.core.data.entitymeta.meta.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaProjectileMetadata
import ru.melonhell.umpa.core.wrappers.UmpaItemStack
import java.util.*

open class UmpaFireworkRocketMetadata(
	var fireworksItem: Optional<UmpaItemStack> = Optional.empty(),
	var attachedToTarget: OptionalInt = OptionalInt.empty(),
	var shotAtAngle: Boolean = false
) : UmpaProjectileMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaFireworkRocketMetadata {
		return super.clone() as UmpaFireworkRocketMetadata
	}

	companion object {
		private val empty = UmpaFireworkRocketMetadata()
	}
}
