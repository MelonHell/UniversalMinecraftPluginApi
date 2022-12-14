package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaMonsterMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaEndermanMetadata
import ru.melonhell.umpa.core.wrappers.UmpaBlockData
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaEndermanMetadataEditor : UmpaMonsterMetadataEditor {

    fun readBlockInHandsId(raw: UmpaRawEntityMetadata): Optional<UmpaBlockData>?
    fun writeBlockInHandsId(raw: UmpaRawEntityMetadata, value: Optional<UmpaBlockData>?)

    fun readCreepy(raw: UmpaRawEntityMetadata): Boolean?
    fun writeCreepy(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readStaredAt(raw: UmpaRawEntityMetadata): Boolean?
    fun writeStaredAt(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaEndermanMetadata =
        UmpaEndermanMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaEndermanMetadata) return
        readBlockInHandsId(raw)?.let { meta.blockInHandsId = it }
        readCreepy(raw)?.let { meta.creepy = it }
        readStaredAt(raw)?.let { meta.staredAt = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaEndermanMetadata) return
        writeBlockInHandsId(raw, meta.blockInHandsId)
        writeCreepy(raw, meta.creepy)
        writeStaredAt(raw, meta.staredAt)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaEndermanMetadata::class.java
}