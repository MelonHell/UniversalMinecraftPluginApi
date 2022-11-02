package ru.melonhell.umpa.core.data.entitymeta.editor.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaGiantMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaMonsterMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaGiantMetadataEditor : UmpaMonsterMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaGiantMetadata =
        UmpaGiantMetadata().apply { readAll(raw, this) }
}