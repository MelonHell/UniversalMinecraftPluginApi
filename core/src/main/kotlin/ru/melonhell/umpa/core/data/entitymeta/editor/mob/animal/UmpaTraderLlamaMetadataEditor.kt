package ru.melonhell.umpa.core.data.entitymeta.editor.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaTraderLlamaMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaTraderLlamaMetadataEditor : UmpaLlamaMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaTraderLlamaMetadata =
        UmpaTraderLlamaMetadata().apply { readAll(raw, this) }
}