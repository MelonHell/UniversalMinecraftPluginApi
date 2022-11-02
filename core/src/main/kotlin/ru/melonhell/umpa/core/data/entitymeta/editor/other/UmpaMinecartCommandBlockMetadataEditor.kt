package ru.melonhell.umpa.core.data.entitymeta.editor.other

import net.kyori.adventure.text.Component
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaMinecartCommandBlockMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractMinecartMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaMinecartCommandBlockMetadataEditor : UmpaAbstractMinecartMetadataEditor {

    fun readCommandName(raw: UmpaRawEntityMetadata): String?
    fun writeCommandName(raw: UmpaRawEntityMetadata, value: String?)

    fun readLastOutput(raw: UmpaRawEntityMetadata): Component?
    fun writeLastOutput(raw: UmpaRawEntityMetadata, value: Component?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaMinecartCommandBlockMetadata =
        UmpaMinecartCommandBlockMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaMinecartCommandBlockMetadata) return
        readCommandName(raw)?.let { meta.commandName = it }
        readLastOutput(raw)?.let { meta.lastOutput = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaMinecartCommandBlockMetadata) return
        writeCommandName(raw, meta.commandName)
        writeLastOutput(raw, meta.lastOutput)
    }
}