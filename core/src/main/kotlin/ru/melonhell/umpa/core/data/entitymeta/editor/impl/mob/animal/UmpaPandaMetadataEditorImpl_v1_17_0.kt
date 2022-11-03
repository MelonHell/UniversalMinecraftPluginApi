package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaPandaMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAnimalMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaPandaMetadataEditorImpl_v1_17_0 : UmpaPandaMetadataEditor, UmpaAnimalMetadataEditorImpl_v1_17_0() {
    override fun readUnhappyCounter(raw: UmpaRawEntityMetadata) = raw.getValue(17, Int::class.java)
    override fun writeUnhappyCounter(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(17, value)

    override fun readSneezeCounter(raw: UmpaRawEntityMetadata) = raw.getValue(18, Int::class.java)
    override fun writeSneezeCounter(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(18, value)

    override fun readEatCounter(raw: UmpaRawEntityMetadata) = raw.getValue(19, Int::class.java)
    override fun writeEatCounter(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(19, value)

    override fun readMainGene(raw: UmpaRawEntityMetadata) = raw.getValue(20, Byte::class.java)?.toInt()
    override fun writeMainGene(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(20, value?.toByte())

    override fun readHiddenGene(raw: UmpaRawEntityMetadata) = raw.getValue(21, Byte::class.java)?.toInt()
    override fun writeHiddenGene(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(21, value?.toByte())

    override fun readSneezing(raw: UmpaRawEntityMetadata) = raw.getFlag(22, 0)
    override fun writeSneezing(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(22, 0, value)

    override fun readRolling(raw: UmpaRawEntityMetadata) = raw.getFlag(22, 1)
    override fun writeRolling(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(22, 1, value)

    override fun readSitting(raw: UmpaRawEntityMetadata) = raw.getFlag(22, 2)
    override fun writeSitting(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(22, 2, value)

    override fun readOnBack(raw: UmpaRawEntityMetadata) = raw.getFlag(22, 3)
    override fun writeOnBack(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(22, 3, value)
}