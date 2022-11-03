package ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractSchoolingFishMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaAbstractSchoolingFishMetadataEditor : UmpaAbstractFishMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaAbstractSchoolingFishMetadata =
        UmpaAbstractSchoolingFishMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaAbstractSchoolingFishMetadata::class.java
}