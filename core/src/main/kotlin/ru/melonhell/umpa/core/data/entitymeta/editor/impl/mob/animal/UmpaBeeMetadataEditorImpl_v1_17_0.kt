package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaBeeMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAnimalMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaBeeMetadataEditorImpl_v1_17_0 : UmpaBeeMetadataEditor, UmpaAnimalMetadataEditorImpl_v1_17_0() {
    override fun readAngry(raw: UmpaRawEntityMetadata) = raw.readFlag(17, 1)
    override fun writeAngry(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(17, 1, value)

    override fun readHasStung(raw: UmpaRawEntityMetadata) = raw.readFlag(17, 2)
    override fun writeHasStung(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(17, 2, value)

    override fun readHasNectar(raw: UmpaRawEntityMetadata) = raw.readFlag(17, 3)
    override fun writeHasNectar(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(17, 3, value)

    override fun readRemainingAngerTime(raw: UmpaRawEntityMetadata) = raw.readValue(18, Int::class.java)
    override fun writeRemainingAngerTime(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(18, value, Int::class.java)
}