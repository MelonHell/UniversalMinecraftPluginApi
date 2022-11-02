package ru.melonhell.umpa.core.data.entitymeta.editor.other

import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaMinecartHopperMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractMinecartContainerMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaMinecartHopperMetadataEditor : UmpaAbstractMinecartContainerMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaMinecartHopperMetadata =
        UmpaMinecartHopperMetadata().apply { readAll(raw, this) }
}