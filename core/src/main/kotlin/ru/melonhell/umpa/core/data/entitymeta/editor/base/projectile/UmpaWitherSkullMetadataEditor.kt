package ru.melonhell.umpa.core.data.entitymeta.editor.base.projectile

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractHurtingProjectileMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.projectile.UmpaWitherSkullMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaWitherSkullMetadataEditor : UmpaAbstractHurtingProjectileMetadataEditor {

    fun readInvulnerable(raw: UmpaRawEntityMetadata): Boolean?
    fun writeInvulnerable(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaWitherSkullMetadata =
        UmpaWitherSkullMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaWitherSkullMetadata) return
        readInvulnerable(raw)?.let { meta.invulnerable = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaWitherSkullMetadata) return
        writeInvulnerable(raw, meta.invulnerable)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaWitherSkullMetadata::class.java
}