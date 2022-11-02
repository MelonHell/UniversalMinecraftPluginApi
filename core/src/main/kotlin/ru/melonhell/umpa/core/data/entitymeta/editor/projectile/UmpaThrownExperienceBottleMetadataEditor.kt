package ru.melonhell.umpa.core.data.entitymeta.editor.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.projectile.UmpaThrownExperienceBottleMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaThrowableItemProjectileMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaThrownExperienceBottleMetadataEditor : UmpaThrowableItemProjectileMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaThrownExperienceBottleMetadata =
        UmpaThrownExperienceBottleMetadata().apply { readAll(raw, this) }
}