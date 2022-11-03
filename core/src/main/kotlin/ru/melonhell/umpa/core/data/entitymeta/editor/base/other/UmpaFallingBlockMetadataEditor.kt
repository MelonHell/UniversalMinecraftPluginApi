package ru.melonhell.umpa.core.data.entitymeta.editor.base.other

import ru.melonhell.umpa.core.data.entitymeta.editor.base.UmpaEntityMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaFallingBlockMetadata
import ru.melonhell.umpa.core.utils.UmpaBlockPos
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaFallingBlockMetadataEditor : UmpaEntityMetadataEditor {

    fun readStartPos(raw: UmpaRawEntityMetadata): UmpaBlockPos?
    fun writeStartPos(raw: UmpaRawEntityMetadata, value: UmpaBlockPos?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaFallingBlockMetadata =
        UmpaFallingBlockMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaFallingBlockMetadata) return
        readStartPos(raw)?.let { meta.startPos = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaFallingBlockMetadata) return
        writeStartPos(raw, meta.startPos)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaFallingBlockMetadata::class.java
}