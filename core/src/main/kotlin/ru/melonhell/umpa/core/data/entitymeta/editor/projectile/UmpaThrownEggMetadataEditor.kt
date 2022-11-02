package ru.melonhell.umpa.core.data.entitymeta.editor.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.projectile.UmpaThrownEggMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaThrowableItemProjectileMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaThrownEggMetadataEditor : UmpaThrowableItemProjectileMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaThrownEggMetadata =
        UmpaThrownEggMetadata().apply { readAll(raw, this) }
}