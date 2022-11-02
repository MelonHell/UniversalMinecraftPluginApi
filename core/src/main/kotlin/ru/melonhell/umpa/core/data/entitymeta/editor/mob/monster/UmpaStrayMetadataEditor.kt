package ru.melonhell.umpa.core.data.entitymeta.editor.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaStrayMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractSkeletonMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaStrayMetadataEditor : UmpaAbstractSkeletonMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaStrayMetadata =
        UmpaStrayMetadata().apply { readAll(raw, this) }
}