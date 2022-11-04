package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaStriderMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAnimalMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaStriderMetadataEditorImpl_v1_17_0 : UmpaStriderMetadataEditor, UmpaAnimalMetadataEditorImpl_v1_17_0() {
    override fun readBoostTime(raw: UmpaRawEntityMetadata) = raw.readValue(17, Int::class.java)
    override fun writeBoostTime(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(17, value, Int::class.java)

    override fun readSuffocating(raw: UmpaRawEntityMetadata) = raw.readValue(18, Boolean::class.java)
    override fun writeSuffocating(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(18, value, Boolean::class.java)

    override fun readSaddle(raw: UmpaRawEntityMetadata) = raw.readValue(19, Boolean::class.java)
    override fun writeSaddle(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(19, value, Boolean::class.java)
}