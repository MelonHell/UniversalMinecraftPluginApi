package ru.melonhell.umpa.core.data.entitymeta.editor.base.projectile

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractHurtingProjectileMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.projectile.UmpaDragonFireballMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaDragonFireballMetadataEditor : UmpaAbstractHurtingProjectileMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaDragonFireballMetadata =
        UmpaDragonFireballMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaDragonFireballMetadata::class.java
}