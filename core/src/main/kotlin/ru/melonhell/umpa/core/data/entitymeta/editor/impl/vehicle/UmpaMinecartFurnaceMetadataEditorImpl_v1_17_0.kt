package ru.melonhell.umpa.core.data.entitymeta.editor.impl.vehicle

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.vehicle.UmpaMinecartFurnaceMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAbstractMinecartMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaMinecartFurnaceMetadataEditorImpl_v1_17_0 : UmpaMinecartFurnaceMetadataEditor,
    UmpaAbstractMinecartMetadataEditorImpl_v1_17_0() {
    override fun readFuel(raw: UmpaRawEntityMetadata) = raw.readValue(14, Boolean::class.java)
    override fun writeFuel(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(14, value, Boolean::class.java)
}