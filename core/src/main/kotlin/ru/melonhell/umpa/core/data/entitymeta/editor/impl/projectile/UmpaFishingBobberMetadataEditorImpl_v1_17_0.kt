package ru.melonhell.umpa.core.data.entitymeta.editor.impl.projectile

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.projectile.UmpaFishingBobberMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaProjectileMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaFishingBobberMetadataEditorImpl_v1_17_0 : UmpaFishingBobberMetadataEditor,
    UmpaProjectileMetadataEditorImpl_v1_17_0() {
    override fun readHookedEntityId(raw: UmpaRawEntityMetadata) = raw.getValue(8, Int::class.java)
    override fun writeHookedEntityId(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(8, value)

    override fun readBiting(raw: UmpaRawEntityMetadata) = raw.getValue(9, Boolean::class.java)
    override fun writeBiting(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(9, value)
}