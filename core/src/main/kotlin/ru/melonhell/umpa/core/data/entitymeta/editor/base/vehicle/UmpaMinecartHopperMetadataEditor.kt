package ru.melonhell.umpa.core.data.entitymeta.editor.base.vehicle

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractMinecartContainerMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.vehicle.UmpaMinecartHopperMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaMinecartHopperMetadataEditor : UmpaAbstractMinecartContainerMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaMinecartHopperMetadata =
        UmpaMinecartHopperMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaMinecartHopperMetadata::class.java
}