package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.monster.raider

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster.raider.UmpaWitchMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaRaiderMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaWitchMetadataEditorImpl_v1_17_0 : UmpaWitchMetadataEditor, UmpaRaiderMetadataEditorImpl_v1_17_0() {
    override fun readUsingItem(raw: UmpaRawEntityMetadata) = raw.readValue(17, Boolean::class.java)
    override fun writeUsingItem(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(17, value, Boolean::class.java)
}