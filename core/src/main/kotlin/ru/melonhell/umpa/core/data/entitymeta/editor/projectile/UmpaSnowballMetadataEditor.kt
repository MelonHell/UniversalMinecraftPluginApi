package ru.melonhell.umpa.core.data.entitymeta.editor.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.projectile.UmpaSnowballMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaThrowableItemProjectileMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaSnowballMetadataEditor : UmpaThrowableItemProjectileMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaSnowballMetadata =
        UmpaSnowballMetadata().apply { readAll(raw, this) }
}