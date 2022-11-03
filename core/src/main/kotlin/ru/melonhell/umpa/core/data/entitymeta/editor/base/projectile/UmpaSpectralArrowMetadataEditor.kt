package ru.melonhell.umpa.core.data.entitymeta.editor.base.projectile

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractArrowMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.projectile.UmpaSpectralArrowMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaSpectralArrowMetadataEditor : UmpaAbstractArrowMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaSpectralArrowMetadata =
        UmpaSpectralArrowMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaSpectralArrowMetadata::class.java
}