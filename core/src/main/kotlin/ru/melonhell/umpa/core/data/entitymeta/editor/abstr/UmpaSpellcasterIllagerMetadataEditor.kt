package ru.melonhell.umpa.core.data.entitymeta.editor.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaSpellcasterIllagerMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaSpellcasterIllagerMetadataEditor : UmpaAbstractIllagerMetadataEditor {

    fun readSpellCasting(raw: UmpaRawEntityMetadata): UmpaSpellcasterIllagerMetadata.Spell?
    fun writeSpellCasting(raw: UmpaRawEntityMetadata, value: UmpaSpellcasterIllagerMetadata.Spell?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaSpellcasterIllagerMetadata =
        UmpaSpellcasterIllagerMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaSpellcasterIllagerMetadata) return
        readSpellCasting(raw)?.let { meta.spellCasting = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaSpellcasterIllagerMetadata) return
        writeSpellCasting(raw, meta.spellCasting)
    }
}