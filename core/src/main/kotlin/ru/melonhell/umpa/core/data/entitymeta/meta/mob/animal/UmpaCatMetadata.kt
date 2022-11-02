package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaTamableAnimalMetadata
import ru.melonhell.umpa.core.enums.UmpaDyeColor

open class UmpaCatMetadata(
	var type: Type = Type.BLACK,
	var isLying: Boolean = false,
	var relaxStateOne: Boolean = false,
	var collarColor: UmpaDyeColor = UmpaDyeColor.RED
) : UmpaTamableAnimalMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaCatMetadata {
		return super.clone() as UmpaCatMetadata
	}

	companion object {
		private val empty = UmpaCatMetadata()
	}

	enum class Type {
		TABBY,
		BLACK,
		RED,
		SIAMESE,
		BRITISH_SHORTHAIR,
		CALICO,
		PERSIAN,
		RAGDOLL,
		WHITE,
		JELLIE,
		ALL_BLACK
	}
}
