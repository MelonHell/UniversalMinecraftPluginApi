package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractHorseMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaSkeletonHorseMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaSkeletonHorseMetadataEditor : UmpaAbstractHorseMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaSkeletonHorseMetadata =
        UmpaSkeletonHorseMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaSkeletonHorseMetadata::class.java
}