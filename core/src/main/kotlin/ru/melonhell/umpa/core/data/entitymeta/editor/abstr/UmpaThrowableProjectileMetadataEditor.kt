package ru.melonhell.umpa.core.data.entitymeta.editor.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaThrowableProjectileMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaThrowableProjectileMetadataEditor : UmpaProjectileMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaThrowableProjectileMetadata =
        UmpaThrowableProjectileMetadata().apply { readAll(raw, this) }
}