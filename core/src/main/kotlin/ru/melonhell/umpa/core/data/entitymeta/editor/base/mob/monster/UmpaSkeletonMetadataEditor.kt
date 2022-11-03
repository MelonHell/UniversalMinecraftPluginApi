package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractSkeletonMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaSkeletonMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaSkeletonMetadataEditor : UmpaAbstractSkeletonMetadataEditor {

    fun readStrayConversion(raw: UmpaRawEntityMetadata): Boolean?
    fun writeStrayConversion(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaSkeletonMetadata =
        UmpaSkeletonMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaSkeletonMetadata) return
        readStrayConversion(raw)?.let { meta.strayConversion = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaSkeletonMetadata) return
        writeStrayConversion(raw, meta.strayConversion)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaSkeletonMetadata::class.java
}