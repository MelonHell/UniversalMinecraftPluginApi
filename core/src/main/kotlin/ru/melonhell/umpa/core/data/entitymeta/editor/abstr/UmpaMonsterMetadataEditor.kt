package ru.melonhell.umpa.core.data.entitymeta.editor.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaMonsterMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaMonsterMetadataEditor : UmpaPathfinderMobMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaMonsterMetadata =
        UmpaMonsterMetadata().apply { readAll(raw, this) }
}