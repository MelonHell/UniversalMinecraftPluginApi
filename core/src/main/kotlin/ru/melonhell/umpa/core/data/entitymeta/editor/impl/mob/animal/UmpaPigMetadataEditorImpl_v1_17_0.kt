package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaPigMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAnimalMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaPigMetadataEditorImpl_v1_17_0 : UmpaPigMetadataEditor, UmpaAnimalMetadataEditorImpl_v1_17_0() {
    override fun readHasSaddle(raw: UmpaRawEntityMetadata) = raw.getValue(17, Boolean::class.java)
    override fun writeHasSaddle(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(17, value)

    override fun readBoostTime(raw: UmpaRawEntityMetadata) = raw.getValue(18, Int::class.java)
    override fun writeBoostTime(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(18, value)
}