package ru.melonhell.umpa.core.data.entitymeta.editor.mob.monster.raider

import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.raider.UmpaRavagerMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaRaiderMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaRavagerMetadataEditor : UmpaRaiderMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaRavagerMetadata =
        UmpaRavagerMetadata().apply { readAll(raw, this) }
}