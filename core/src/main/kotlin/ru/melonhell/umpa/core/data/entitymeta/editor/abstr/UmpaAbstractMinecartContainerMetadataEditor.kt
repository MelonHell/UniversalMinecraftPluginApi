package ru.melonhell.umpa.core.data.entitymeta.editor.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractMinecartContainerMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaAbstractMinecartContainerMetadataEditor : UmpaAbstractMinecartMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaAbstractMinecartContainerMetadata =
        UmpaAbstractMinecartContainerMetadata().apply { readAll(raw, this) }
}