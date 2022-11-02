package ru.melonhell.umpa.core.data.entitymeta.editor.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.projectile.UmpaLlamaSpitMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaProjectileMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaLlamaSpitMetadataEditor : UmpaProjectileMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaLlamaSpitMetadata =
        UmpaLlamaSpitMetadata().apply { readAll(raw, this) }
}