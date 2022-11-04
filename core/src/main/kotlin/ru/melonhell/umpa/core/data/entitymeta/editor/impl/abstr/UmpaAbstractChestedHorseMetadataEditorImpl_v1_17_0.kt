package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractChestedHorseMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaAbstractChestedHorseMetadataEditorImpl_v1_17_0 : UmpaAbstractChestedHorseMetadataEditor,
    UmpaAbstractHorseMetadataEditorImpl_v1_17_0() {

    override fun readHasChest(raw: UmpaRawEntityMetadata) = raw.readValue(19, Boolean::class.java)
    override fun writeHasChest(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(19, value, Boolean::class.java)

}