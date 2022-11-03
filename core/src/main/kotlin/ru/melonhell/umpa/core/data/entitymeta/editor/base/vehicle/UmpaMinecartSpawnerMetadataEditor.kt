package ru.melonhell.umpa.core.data.entitymeta.editor.base.vehicle

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractMinecartMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.vehicle.UmpaMinecartSpawnerMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaMinecartSpawnerMetadataEditor : UmpaAbstractMinecartMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaMinecartSpawnerMetadata =
        UmpaMinecartSpawnerMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaMinecartSpawnerMetadata::class.java
}