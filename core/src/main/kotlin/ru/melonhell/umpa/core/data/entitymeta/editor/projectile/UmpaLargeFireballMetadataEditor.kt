package ru.melonhell.umpa.core.data.entitymeta.editor.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.projectile.UmpaLargeFireballMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaFireballMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaLargeFireballMetadataEditor : UmpaFireballMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaLargeFireballMetadata =
        UmpaLargeFireballMetadata().apply { readAll(raw, this) }
}