package ru.melonhell.umpa.core.data.entitymeta.editor.other

import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaLightningBoltMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaLightningBoltMetadataEditor : ru.melonhell.umpa.core.data.entitymeta.editor.UmpaEntityMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaLightningBoltMetadata =
        UmpaLightningBoltMetadata().apply { readAll(raw, this) }
}