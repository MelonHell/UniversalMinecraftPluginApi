package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaMonsterMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaVexMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaVexMetadataEditor : UmpaMonsterMetadataEditor {

    fun readAttacking(raw: UmpaRawEntityMetadata): Boolean?
    fun writeAttacking(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaVexMetadata = UmpaVexMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaVexMetadata) return
        readAttacking(raw)?.let { meta.attacking = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaVexMetadata) return
        writeAttacking(raw, meta.attacking)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaVexMetadata::class.java
}