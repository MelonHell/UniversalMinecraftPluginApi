package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractSkeletonMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaWitherSkeletonMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaWitherSkeletonMetadataEditor : UmpaAbstractSkeletonMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaWitherSkeletonMetadata =
        UmpaWitherSkeletonMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaWitherSkeletonMetadata::class.java
}