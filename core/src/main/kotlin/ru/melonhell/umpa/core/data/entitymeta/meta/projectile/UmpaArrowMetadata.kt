package ru.melonhell.umpa.core.data.entitymeta.meta.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractArrowMetadata
import ru.melonhell.umpa.core.utils.UmpaColor
import java.util.*

open class UmpaArrowMetadata(
	var effectColor: Optional<UmpaColor> = Optional.empty()
) : UmpaAbstractArrowMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaArrowMetadata {
		return super.clone() as UmpaArrowMetadata
	}

	companion object {
		private val empty = UmpaArrowMetadata()
	}
}
