package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaGoatMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAnimalMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaGoatMetadataEditorImpl_v1_17_0 : UmpaGoatMetadataEditor, UmpaAnimalMetadataEditorImpl_v1_17_0() {
    override fun readScreaming(raw: UmpaRawEntityMetadata) = raw.getValue(17, Boolean::class.java)
    override fun writeScreaming(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(17, value)

    override fun readHasLeftHorn(raw: UmpaRawEntityMetadata) = raw.getValue(18, Boolean::class.java)
    override fun writeHasLeftHorn(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(18, value)

    override fun readHasRightHorn(raw: UmpaRawEntityMetadata) = raw.getValue(19, Boolean::class.java)
    override fun writeHasRightHorn(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(19, value)
}