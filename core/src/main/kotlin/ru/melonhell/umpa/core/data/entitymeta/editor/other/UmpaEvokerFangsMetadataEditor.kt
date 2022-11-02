package ru.melonhell.umpa.core.data.entitymeta.editor.other

import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaEvokerFangsMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaEvokerFangsMetadataEditor : ru.melonhell.umpa.core.data.entitymeta.editor.UmpaEntityMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaEvokerFangsMetadata =
        UmpaEvokerFangsMetadata().apply { readAll(raw, this) }
}