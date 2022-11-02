package ru.melonhell.umpa.core.data.entitymeta.editor.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaFlyingMobMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaFlyingMobMetadataEditor : UmpaMobMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaFlyingMobMetadata =
        UmpaFlyingMobMetadata().apply { readAll(raw, this) }
}