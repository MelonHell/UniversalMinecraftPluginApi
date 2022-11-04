package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.UmpaGhastMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaFlyingMobMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaGhastMetadataEditorImpl_v1_17_0 : UmpaGhastMetadataEditor, UmpaFlyingMobMetadataEditorImpl_v1_17_0() {
    override fun readAttacking(raw: UmpaRawEntityMetadata) = raw.readValue(16, Boolean::class.java)
    override fun writeAttacking(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(16, value, Boolean::class.java)
}