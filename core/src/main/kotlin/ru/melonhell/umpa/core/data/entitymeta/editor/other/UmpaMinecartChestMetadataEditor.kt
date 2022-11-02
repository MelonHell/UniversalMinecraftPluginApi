package ru.melonhell.umpa.core.data.entitymeta.editor.other

import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaMinecartChestMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractMinecartContainerMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaMinecartChestMetadataEditor : UmpaAbstractMinecartContainerMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaMinecartChestMetadata =
        UmpaMinecartChestMetadata().apply { readAll(raw, this) }
}