package ru.melonhell.umpa.core.data.entitymeta.editor.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractSchoolingFishMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaAbstractSchoolingFishMetadataEditor : UmpaAbstractFishMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaAbstractSchoolingFishMetadata =
        UmpaAbstractSchoolingFishMetadata().apply { readAll(raw, this) }
}