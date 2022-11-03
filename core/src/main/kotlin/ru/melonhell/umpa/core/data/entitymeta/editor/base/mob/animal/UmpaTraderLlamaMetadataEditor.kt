package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaTraderLlamaMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaTraderLlamaMetadataEditor : UmpaLlamaMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaTraderLlamaMetadata =
        UmpaTraderLlamaMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaTraderLlamaMetadata::class.java
}