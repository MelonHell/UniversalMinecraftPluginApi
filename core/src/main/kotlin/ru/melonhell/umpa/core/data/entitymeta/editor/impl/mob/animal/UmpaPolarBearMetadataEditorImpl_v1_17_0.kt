package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaPolarBearMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAnimalMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaPolarBearMetadataEditorImpl_v1_17_0 : UmpaPolarBearMetadataEditor,
    UmpaAnimalMetadataEditorImpl_v1_17_0() {
    override fun readStanding(raw: UmpaRawEntityMetadata) = raw.getValue(17, Boolean::class.java)
    override fun writeStanding(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(17, value)
}