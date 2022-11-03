package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaMonsterMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaSpiderMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaSpiderMetadataEditor : UmpaMonsterMetadataEditor {

    fun readClimbing(raw: UmpaRawEntityMetadata): Boolean?
    fun writeClimbing(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaSpiderMetadata =
        UmpaSpiderMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaSpiderMetadata) return
        readClimbing(raw)?.let { meta.climbing = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaSpiderMetadata) return
        writeClimbing(raw, meta.climbing)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaSpiderMetadata::class.java
}