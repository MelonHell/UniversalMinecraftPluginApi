package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaMonsterMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaWardenMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaWardenMetadataEditor : UmpaMonsterMetadataEditor {

    fun readAngerLevel(raw: UmpaRawEntityMetadata): Int?
    fun writeAngerLevel(raw: UmpaRawEntityMetadata, value: Int?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaWardenMetadata =
        UmpaWardenMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaWardenMetadata) return
        readAngerLevel(raw)?.let { meta.angerLevel = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaWardenMetadata) return
        writeAngerLevel(raw, meta.angerLevel)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaWardenMetadata::class.java
}