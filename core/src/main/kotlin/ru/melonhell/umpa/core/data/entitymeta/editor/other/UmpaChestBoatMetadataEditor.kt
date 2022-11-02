package ru.melonhell.umpa.core.data.entitymeta.editor.other

import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaChestBoatMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaChestBoatMetadataEditor : UmpaBoatMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaChestBoatMetadata =
        UmpaChestBoatMetadata().apply { readAll(raw, this) }
}