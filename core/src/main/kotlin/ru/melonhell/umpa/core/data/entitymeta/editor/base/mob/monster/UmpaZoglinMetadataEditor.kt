package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaMonsterMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaZoglinMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaZoglinMetadataEditor : UmpaMonsterMetadataEditor {

    fun readBaby(raw: UmpaRawEntityMetadata): Boolean?
    fun writeBaby(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaZoglinMetadata =
        UmpaZoglinMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaZoglinMetadata) return
        readBaby(raw)?.let { meta.baby = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaZoglinMetadata) return
        writeBaby(raw, meta.baby)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaZoglinMetadata::class.java
}