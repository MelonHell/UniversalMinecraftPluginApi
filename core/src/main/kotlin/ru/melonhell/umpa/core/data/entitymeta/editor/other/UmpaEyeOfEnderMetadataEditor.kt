package ru.melonhell.umpa.core.data.entitymeta.editor.other

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaEyeOfEnderMetadata
import ru.melonhell.umpa.core.wrappers.UmpaItemStack
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaEyeOfEnderMetadataEditor : ru.melonhell.umpa.core.data.entitymeta.editor.UmpaEntityMetadataEditor {

    fun readItemStack(raw: UmpaRawEntityMetadata): Optional<UmpaItemStack>?
    fun writeItemStack(raw: UmpaRawEntityMetadata, value: Optional<UmpaItemStack>?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaEyeOfEnderMetadata =
        UmpaEyeOfEnderMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaEyeOfEnderMetadata) return
        readItemStack(raw)?.let { meta.itemStack = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaEyeOfEnderMetadata) return
        writeItemStack(raw, meta.itemStack)
    }
}