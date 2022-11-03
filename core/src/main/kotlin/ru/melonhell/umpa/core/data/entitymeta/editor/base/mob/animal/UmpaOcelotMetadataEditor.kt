package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAnimalMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaOcelotMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaOcelotMetadataEditor : UmpaAnimalMetadataEditor {

    fun readTrusting(raw: UmpaRawEntityMetadata): Boolean?
    fun writeTrusting(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaOcelotMetadata =
        UmpaOcelotMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaOcelotMetadata) return
        readTrusting(raw)?.let { meta.trusting = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaOcelotMetadata) return
        writeTrusting(raw, meta.trusting)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaOcelotMetadata::class.java
}