package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster.raider

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaRaiderMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.raider.UmpaWitchMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaWitchMetadataEditor : UmpaRaiderMetadataEditor {

    fun readUsingItem(raw: UmpaRawEntityMetadata): Boolean?
    fun writeUsingItem(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaWitchMetadata =
        UmpaWitchMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaWitchMetadata) return
        readUsingItem(raw)?.let { meta.usingItem = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaWitchMetadata) return
        writeUsingItem(raw, meta.usingItem)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaWitchMetadata::class.java
}