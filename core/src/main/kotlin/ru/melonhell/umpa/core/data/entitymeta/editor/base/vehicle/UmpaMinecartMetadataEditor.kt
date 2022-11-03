package ru.melonhell.umpa.core.data.entitymeta.editor.base.vehicle

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractMinecartMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.vehicle.UmpaMinecartMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaMinecartMetadataEditor : UmpaAbstractMinecartMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaMinecartMetadata =
        UmpaMinecartMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaMinecartMetadata::class.java
}