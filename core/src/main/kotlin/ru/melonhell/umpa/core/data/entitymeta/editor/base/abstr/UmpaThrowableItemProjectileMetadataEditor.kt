package ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaThrowableItemProjectileMetadata
import ru.melonhell.umpa.core.wrappers.UmpaItemStack
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaThrowableItemProjectileMetadataEditor : UmpaThrowableProjectileMetadataEditor {

    fun readItemStack(raw: UmpaRawEntityMetadata): Optional<UmpaItemStack>?
    fun writeItemStack(raw: UmpaRawEntityMetadata, value: Optional<UmpaItemStack>?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaThrowableItemProjectileMetadata =
        UmpaThrowableItemProjectileMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaThrowableItemProjectileMetadata) return
        readItemStack(raw)?.let { meta.itemStack = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaThrowableItemProjectileMetadata) return
        writeItemStack(raw, meta.itemStack)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaThrowableItemProjectileMetadata::class.java
}