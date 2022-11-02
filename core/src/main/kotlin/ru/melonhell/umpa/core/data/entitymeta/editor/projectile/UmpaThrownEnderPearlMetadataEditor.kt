package ru.melonhell.umpa.core.data.entitymeta.editor.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.projectile.UmpaThrownEnderPearlMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaThrowableItemProjectileMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaThrownEnderPearlMetadataEditor : UmpaThrowableItemProjectileMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaThrownEnderPearlMetadata =
        UmpaThrownEnderPearlMetadata().apply { readAll(raw, this) }
}