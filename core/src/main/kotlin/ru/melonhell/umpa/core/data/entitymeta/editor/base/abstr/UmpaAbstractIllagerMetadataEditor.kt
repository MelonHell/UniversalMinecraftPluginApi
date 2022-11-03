package ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractIllagerMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaAbstractIllagerMetadataEditor : UmpaRaiderMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaAbstractIllagerMetadata =
        UmpaAbstractIllagerMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaAbstractIllagerMetadata::class.java
}