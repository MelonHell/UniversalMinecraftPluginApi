package ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAnimalMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaAnimalMetadataEditor : UmpaAgeableMobMetadataEditor {

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaAnimalMetadata =
        UmpaAnimalMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaAnimalMetadata) return
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaAnimalMetadata) return
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaAnimalMetadata::class.java
}