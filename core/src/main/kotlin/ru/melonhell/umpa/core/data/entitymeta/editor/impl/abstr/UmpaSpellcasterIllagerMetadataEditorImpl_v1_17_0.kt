package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaSpellcasterIllagerMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaSpellcasterIllagerMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaSpellcasterIllagerMetadataEditorImpl_v1_17_0 : UmpaSpellcasterIllagerMetadataEditor,
    UmpaAbstractIllagerMetadataEditorImpl_v1_17_0() {
    var spells = UmpaSpellcasterIllagerMetadata.Spell.values()

    override fun readSpellCasting(raw: UmpaRawEntityMetadata) =
        raw.readValue(17, Byte::class.java)?.let { spells[it.toInt()] }

    override fun writeSpellCasting(raw: UmpaRawEntityMetadata, value: UmpaSpellcasterIllagerMetadata.Spell?) =
        raw.writeValue(17, value?.ordinal?.toByte(), Byte::class.java)
}