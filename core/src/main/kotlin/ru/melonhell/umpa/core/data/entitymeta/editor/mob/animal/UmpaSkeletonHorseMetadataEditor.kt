package ru.melonhell.umpa.core.data.entitymeta.editor.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaSkeletonHorseMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractHorseMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaSkeletonHorseMetadataEditor : UmpaAbstractHorseMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaSkeletonHorseMetadata =
        UmpaSkeletonHorseMetadata().apply { readAll(raw, this) }
}