package ru.melonhell.umpa.core.data.entitymeta.editor.base.vehicle

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractMinecartContainerMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.vehicle.UmpaMinecartChestMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaMinecartChestMetadataEditor : UmpaAbstractMinecartContainerMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaMinecartChestMetadata =
        UmpaMinecartChestMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaMinecartChestMetadata::class.java
}