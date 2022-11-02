package ru.melonhell.umpa.core.data.entitymeta.editor.other

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaEndCrystalMetadata
import ru.melonhell.umpa.core.utils.UmpaBlockPos
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaEndCrystalMetadataEditor : ru.melonhell.umpa.core.data.entitymeta.editor.UmpaEntityMetadataEditor {

    fun readBeamTarget(raw: UmpaRawEntityMetadata): Optional<UmpaBlockPos>?
    fun writeBeamTarget(raw: UmpaRawEntityMetadata, value: Optional<UmpaBlockPos>?)

    fun readShowBottom(raw: UmpaRawEntityMetadata): Boolean?
    fun writeShowBottom(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaEndCrystalMetadata =
        UmpaEndCrystalMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaEndCrystalMetadata) return
        readBeamTarget(raw)?.let { meta.beamTarget = it }
        readShowBottom(raw)?.let { meta.showBottom = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaEndCrystalMetadata) return
        writeBeamTarget(raw, meta.beamTarget)
        writeShowBottom(raw, meta.showBottom)
    }
}