package ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaFireballMetadata
import ru.melonhell.umpa.core.wrappers.UmpaItemStack
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaFireballMetadataEditor : UmpaAbstractHurtingProjectileMetadataEditor {

    fun readItemStack(raw: UmpaRawEntityMetadata): Optional<UmpaItemStack>?
    fun writeItemStack(raw: UmpaRawEntityMetadata, value: Optional<UmpaItemStack>?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaFireballMetadata =
        UmpaFireballMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaFireballMetadata) return
        readItemStack(raw)?.let { meta.itemStack = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaFireballMetadata) return
        writeItemStack(raw, meta.itemStack)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaFireballMetadata::class.java
}