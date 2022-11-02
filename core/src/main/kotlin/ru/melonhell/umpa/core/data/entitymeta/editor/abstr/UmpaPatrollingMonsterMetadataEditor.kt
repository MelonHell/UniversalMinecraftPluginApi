package ru.melonhell.umpa.core.data.entitymeta.editor.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaPatrollingMonsterMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaPatrollingMonsterMetadataEditor : UmpaMonsterMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaPatrollingMonsterMetadata =
        UmpaPatrollingMonsterMetadata().apply { readAll(raw, this) }
}