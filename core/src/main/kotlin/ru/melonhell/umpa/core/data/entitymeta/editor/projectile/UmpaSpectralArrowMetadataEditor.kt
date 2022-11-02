package ru.melonhell.umpa.core.data.entitymeta.editor.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.projectile.UmpaSpectralArrowMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractArrowMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaSpectralArrowMetadataEditor : UmpaAbstractArrowMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaSpectralArrowMetadata =
        UmpaSpectralArrowMetadata().apply { readAll(raw, this) }
}