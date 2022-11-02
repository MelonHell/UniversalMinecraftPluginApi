package ru.melonhell.umpa.core.data.entitymeta.editor.other

import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaMinecartSpawnerMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractMinecartMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaMinecartSpawnerMetadataEditor : UmpaAbstractMinecartMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaMinecartSpawnerMetadata =
        UmpaMinecartSpawnerMetadata().apply { readAll(raw, this) }
}