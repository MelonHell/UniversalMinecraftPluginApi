package ru.melonhell.umpa.core.data.entitymeta.editor.base.vehicle

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.vehicle.UmpaChestBoatMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaChestBoatMetadataEditor : UmpaBoatMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaChestBoatMetadata =
        UmpaChestBoatMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaChestBoatMetadata::class.java
}