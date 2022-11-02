package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

open class UmpaSpellcasterIllagerMetadata(
	var spellCasting: Spell = Spell.NONE
) : UmpaAbstractIllagerMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaSpellcasterIllagerMetadata {
		return super.clone() as UmpaSpellcasterIllagerMetadata
	}

	companion object {
		private val empty = UmpaSpellcasterIllagerMetadata()
	}

	enum class Spell {
		NONE,
		SUMMON_VEX,
		ATTACK,
		WOLOLO,
		DISAPPEAR,
		BLINDNESS
	}
}
