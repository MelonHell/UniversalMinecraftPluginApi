package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAnimalMetadata
import java.util.*

open class UmpaFoxMetadata(
	var type: Type = Type.RED,
	var sitting: Boolean = false,
	var foxCrouching: Boolean = false,
	var interested: Boolean = false,
	var pouncing: Boolean = false,
	var sleeping: Boolean = false,
	var faceplanted: Boolean = false,
	var defending: Boolean = false,
	var trusted0: Optional<UUID> = Optional.empty(),
	var trusted1: Optional<UUID> = Optional.empty(),
) : UmpaAnimalMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaFoxMetadata {
		return super.clone() as UmpaFoxMetadata
	}

	companion object {
		private val empty = UmpaFoxMetadata()
	}

	enum class Type {
		RED,
		SNOW
	}
}
