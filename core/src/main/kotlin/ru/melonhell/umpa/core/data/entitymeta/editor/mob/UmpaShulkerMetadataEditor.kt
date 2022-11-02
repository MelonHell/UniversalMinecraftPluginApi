package ru.melonhell.umpa.core.data.entitymeta.editor.mob

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.UmpaShulkerMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractGolemMetadataEditor
import ru.melonhell.umpa.core.enums.UmpaDyeColor
import ru.melonhell.umpa.core.utils.UmpaBlockPos
import ru.melonhell.umpa.core.utils.UmpaDirection
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaShulkerMetadataEditor : UmpaAbstractGolemMetadataEditor {

    fun readAttachFace(raw: UmpaRawEntityMetadata): UmpaDirection?
    fun writeAttachFace(raw: UmpaRawEntityMetadata, value: UmpaDirection?)

    fun readAttachPos(raw: UmpaRawEntityMetadata): UmpaBlockPos?
    fun writeAttachPos(raw: UmpaRawEntityMetadata, value: UmpaBlockPos?)

    fun readPeek(raw: UmpaRawEntityMetadata): Int?
    fun writePeek(raw: UmpaRawEntityMetadata, value: Int?)

    fun readCustomColor(raw: UmpaRawEntityMetadata): Optional<UmpaDyeColor>?
    fun writeCustomColor(raw: UmpaRawEntityMetadata, value: Optional<UmpaDyeColor>?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaShulkerMetadata =
        UmpaShulkerMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaShulkerMetadata) return
        readAttachFace(raw)?.let { meta.attachFace = it }
        readAttachPos(raw)?.let { meta.attachPos = it }
        readPeek(raw)?.let { meta.peek = it }
        readCustomColor(raw)?.let { meta.customColor = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaShulkerMetadata) return
        writeAttachFace(raw, meta.attachFace)
        writeAttachPos(raw, meta.attachPos)
        writePeek(raw, meta.peek)
        writeCustomColor(raw, meta.customColor)
    }
}