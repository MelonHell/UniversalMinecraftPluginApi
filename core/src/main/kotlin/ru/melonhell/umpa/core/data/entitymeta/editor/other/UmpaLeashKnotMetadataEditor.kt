package ru.melonhell.umpa.core.data.entitymeta.editor.other

import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaLeashKnotMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaHangingEntityMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaLeashKnotMetadataEditor : UmpaHangingEntityMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaLeashKnotMetadata =
        UmpaLeashKnotMetadata().apply { readAll(raw, this) }
}