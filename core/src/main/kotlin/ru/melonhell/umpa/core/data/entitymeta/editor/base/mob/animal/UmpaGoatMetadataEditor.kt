package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAnimalMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaGoatMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaGoatMetadataEditor : UmpaAnimalMetadataEditor {

    fun readScreaming(raw: UmpaRawEntityMetadata): Boolean?
    fun writeScreaming(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readHasLeftHorn(raw: UmpaRawEntityMetadata): Boolean?
    fun writeHasLeftHorn(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readHasRightHorn(raw: UmpaRawEntityMetadata): Boolean?
    fun writeHasRightHorn(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaGoatMetadata = UmpaGoatMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaGoatMetadata) return
        readScreaming(raw)?.let { meta.screaming = it }
        readHasLeftHorn(raw)?.let { meta.hasLeftHorn = it }
        readHasRightHorn(raw)?.let { meta.hasRightHorn = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaGoatMetadata) return
        writeScreaming(raw, meta.screaming)
        writeHasLeftHorn(raw, meta.hasLeftHorn)
        writeHasRightHorn(raw, meta.hasRightHorn)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaGoatMetadata::class.java
}