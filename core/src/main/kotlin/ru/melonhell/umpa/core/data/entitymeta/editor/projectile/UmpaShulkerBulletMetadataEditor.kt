package ru.melonhell.umpa.core.data.entitymeta.editor.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.projectile.UmpaShulkerBulletMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaProjectileMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaShulkerBulletMetadataEditor : UmpaProjectileMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaShulkerBulletMetadata =
        UmpaShulkerBulletMetadata().apply { readAll(raw, this) }
}