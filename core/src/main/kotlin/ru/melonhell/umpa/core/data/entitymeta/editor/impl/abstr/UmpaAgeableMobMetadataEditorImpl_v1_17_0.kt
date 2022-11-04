package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAgeableMobMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaAgeableMobMetadataEditorImpl_v1_17_0 : UmpaAgeableMobMetadataEditor,
    UmpaPathfinderMobMetadataEditorImpl_v1_17_0() {
    override fun readBaby(raw: UmpaRawEntityMetadata) = raw.readValue(16, Boolean::class.java)
    override fun writeBaby(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(16, value, Boolean::class.java)
}