package ru.melonhell.umpa.core.data.entitymeta.editor.other

import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaMinecartMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractMinecartMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaMinecartMetadataEditor : UmpaAbstractMinecartMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaMinecartMetadata =
        UmpaMinecartMetadata().apply { readAll(raw, this) }
}