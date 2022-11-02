package ru.melonhell.umpa.core.data.entitymeta.editor.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaHangingEntityMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaHangingEntityMetadataEditor : ru.melonhell.umpa.core.data.entitymeta.editor.UmpaEntityMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaHangingEntityMetadata =
        UmpaHangingEntityMetadata().apply { readAll(raw, this) }
}