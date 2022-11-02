package ru.melonhell.umpa.core.data.entitymeta.editor.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaWitherSkeletonMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractSkeletonMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaWitherSkeletonMetadataEditor : UmpaAbstractSkeletonMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaWitherSkeletonMetadata =
        UmpaWitherSkeletonMetadata().apply { readAll(raw, this) }
}