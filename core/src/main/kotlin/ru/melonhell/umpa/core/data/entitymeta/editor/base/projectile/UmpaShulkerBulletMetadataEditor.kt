package ru.melonhell.umpa.core.data.entitymeta.editor.base.projectile

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaProjectileMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.projectile.UmpaShulkerBulletMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaShulkerBulletMetadataEditor : UmpaProjectileMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaShulkerBulletMetadata =
        UmpaShulkerBulletMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaShulkerBulletMetadata::class.java
}