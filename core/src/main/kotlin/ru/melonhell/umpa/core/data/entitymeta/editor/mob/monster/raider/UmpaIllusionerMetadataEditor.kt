package ru.melonhell.umpa.core.data.entitymeta.editor.mob.monster.raider

import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.raider.UmpaIllusionerMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaSpellcasterIllagerMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaIllusionerMetadataEditor : UmpaSpellcasterIllagerMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaIllusionerMetadata =
        UmpaIllusionerMetadata().apply { readAll(raw, this) }
}