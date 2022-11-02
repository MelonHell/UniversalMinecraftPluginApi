package ru.melonhell.umpa.core.data.entitymeta.editor.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.projectile.UmpaSmallFireballMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaFireballMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaSmallFireballMetadataEditor : UmpaFireballMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaSmallFireballMetadata =
        UmpaSmallFireballMetadata().apply { readAll(raw, this) }
}