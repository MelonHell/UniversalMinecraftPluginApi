package ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractGolemMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaAbstractGolemMetadataEditor : UmpaPathfinderMobMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaAbstractGolemMetadata =
        UmpaAbstractGolemMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaAbstractGolemMetadata::class.java
}