package ru.melonhell.umpa.core.data.entitymeta.editor.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.projectile.UmpaThrownPotionMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaThrowableItemProjectileMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaThrownPotionMetadataEditor : UmpaThrowableItemProjectileMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaThrownPotionMetadata =
        UmpaThrownPotionMetadata().apply { readAll(raw, this) }
}