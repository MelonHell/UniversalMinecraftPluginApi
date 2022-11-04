package ru.melonhell.umpa.core.data.entitymeta.editor.impl.vehicle

import net.kyori.adventure.text.Component
import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.vehicle.UmpaMinecartCommandBlockMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAbstractMinecartMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaMinecartCommandBlockMetadataEditorImpl_v1_17_0 : UmpaMinecartCommandBlockMetadataEditor,
    UmpaAbstractMinecartMetadataEditorImpl_v1_17_0() {
    override fun readCommandName(raw: UmpaRawEntityMetadata) = raw.readValue(14, String::class.java)
    override fun writeCommandName(raw: UmpaRawEntityMetadata, value: String?) = raw.writeValue(14, value, String::class.java)

    override fun readLastOutput(raw: UmpaRawEntityMetadata) = raw.readValue(15, Component::class.java)
    override fun writeLastOutput(raw: UmpaRawEntityMetadata, value: Component?) = raw.writeValue(15, value, Component::class.java)
}