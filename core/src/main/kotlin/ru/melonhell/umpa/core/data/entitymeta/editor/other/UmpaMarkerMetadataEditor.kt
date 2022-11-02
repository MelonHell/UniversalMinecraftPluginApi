package ru.melonhell.umpa.core.data.entitymeta.editor.other

import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaMarkerMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaMarkerMetadataEditor : ru.melonhell.umpa.core.data.entitymeta.editor.UmpaEntityMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaMarkerMetadata =
        UmpaMarkerMetadata().apply { readAll(raw, this) }
}