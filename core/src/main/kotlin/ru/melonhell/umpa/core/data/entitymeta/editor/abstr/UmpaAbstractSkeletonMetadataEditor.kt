package ru.melonhell.umpa.core.data.entitymeta.editor.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractSkeletonMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaAbstractSkeletonMetadataEditor : UmpaMonsterMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaAbstractSkeletonMetadata =
        UmpaAbstractSkeletonMetadata().apply { readAll(raw, this) }
}