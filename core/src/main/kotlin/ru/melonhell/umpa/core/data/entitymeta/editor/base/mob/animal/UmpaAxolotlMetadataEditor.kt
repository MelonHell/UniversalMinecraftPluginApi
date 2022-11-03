package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAnimalMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaAxolotlMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaAxolotlMetadataEditor : UmpaAnimalMetadataEditor {

    fun readType(raw: UmpaRawEntityMetadata): UmpaAxolotlMetadata.Type?
    fun writeType(raw: UmpaRawEntityMetadata, value: UmpaAxolotlMetadata.Type?)

    fun readPlayingDead(raw: UmpaRawEntityMetadata): Boolean?
    fun writePlayingDead(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readFromBucket(raw: UmpaRawEntityMetadata): Boolean?
    fun writeFromBucket(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaAxolotlMetadata =
        UmpaAxolotlMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaAxolotlMetadata) return
        readType(raw)?.let { meta.type = it }
        readPlayingDead(raw)?.let { meta.playingDead = it }
        readFromBucket(raw)?.let { meta.fromBucket = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaAxolotlMetadata) return
        writeType(raw, meta.type)
        writePlayingDead(raw, meta.playingDead)
        writeFromBucket(raw, meta.fromBucket)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaAxolotlMetadata::class.java
}