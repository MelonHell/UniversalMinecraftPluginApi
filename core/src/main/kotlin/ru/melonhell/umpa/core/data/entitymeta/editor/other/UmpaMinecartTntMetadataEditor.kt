package ru.melonhell.umpa.core.data.entitymeta.editor.other

import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaMinecartTntMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractMinecartMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaMinecartTntMetadataEditor : UmpaAbstractMinecartMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaMinecartTntMetadata =
        UmpaMinecartTntMetadata().apply { readAll(raw, this) }
}