package ru.melonhell.umpa.core.data.entitymeta.editor.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractHurtingProjectileMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaAbstractHurtingProjectileMetadataEditor : UmpaProjectileMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaAbstractHurtingProjectileMetadata =
        UmpaAbstractHurtingProjectileMetadata().apply { readAll(raw, this) }
}