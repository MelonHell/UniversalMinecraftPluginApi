package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaPandaMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAnimalMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaPandaMetadataEditorImpl_v1_17_0 : UmpaPandaMetadataEditor, UmpaAnimalMetadataEditorImpl_v1_17_0() {
    override fun readUnhappyCounter(raw: UmpaRawEntityMetadata) = raw.readValue(17, Int::class.java)
    override fun writeUnhappyCounter(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(17, value, Int::class.java)

    override fun readSneezeCounter(raw: UmpaRawEntityMetadata) = raw.readValue(18, Int::class.java)
    override fun writeSneezeCounter(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(18, value, Int::class.java)

    override fun readEatCounter(raw: UmpaRawEntityMetadata) = raw.readValue(19, Int::class.java)
    override fun writeEatCounter(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(19, value, Int::class.java)

    override fun readMainGene(raw: UmpaRawEntityMetadata) = raw.readValue(20, Byte::class.java)?.toInt()
    override fun writeMainGene(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(20, value?.toByte(), Byte::class.java)

    override fun readHiddenGene(raw: UmpaRawEntityMetadata) = raw.readValue(21, Byte::class.java)?.toInt()
    override fun writeHiddenGene(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(21, value?.toByte(), Byte::class.java)

    override fun readSneezing(raw: UmpaRawEntityMetadata) = raw.readFlag(22, 0)
    override fun writeSneezing(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(22, 0, value)

    override fun readRolling(raw: UmpaRawEntityMetadata) = raw.readFlag(22, 1)
    override fun writeRolling(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(22, 1, value)

    override fun readSitting(raw: UmpaRawEntityMetadata) = raw.readFlag(22, 2)
    override fun writeSitting(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(22, 2, value)

    override fun readOnBack(raw: UmpaRawEntityMetadata) = raw.readFlag(22, 3)
    override fun writeOnBack(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(22, 3, value)
}