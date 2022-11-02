package ru.melonhell.umpa.core.data.entitymeta.editor.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.projectile.UmpaDragonFireballMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractHurtingProjectileMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaDragonFireballMetadataEditor : UmpaAbstractHurtingProjectileMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaDragonFireballMetadata =
        UmpaDragonFireballMetadata().apply { readAll(raw, this) }
}