package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaFlyingMobMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.UmpaGhastMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaGhastMetadataEditor : UmpaFlyingMobMetadataEditor {

    fun readAttacking(raw: UmpaRawEntityMetadata): Boolean?
    fun writeAttacking(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaGhastMetadata =
        UmpaGhastMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaGhastMetadata) return
        readAttacking(raw)?.let { meta.attacking = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaGhastMetadata) return
        writeAttacking(raw, meta.attacking)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaGhastMetadata::class.java
}