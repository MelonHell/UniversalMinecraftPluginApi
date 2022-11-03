package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaTurtleMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAnimalMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.utils.UmpaBlockPos
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaTurtleMetadataEditorImpl_v1_17_0 : UmpaTurtleMetadataEditor, UmpaAnimalMetadataEditorImpl_v1_17_0() {
    override fun readHomePos(raw: UmpaRawEntityMetadata) = raw.getValue(17, UmpaBlockPos::class.java)
    override fun writeHomePos(raw: UmpaRawEntityMetadata, value: UmpaBlockPos?) = raw.setValue(17, value)

    override fun readHasEgg(raw: UmpaRawEntityMetadata) = raw.getValue(18, Boolean::class.java)
    override fun writeHasEgg(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(18, value)

    override fun readLayingEgg(raw: UmpaRawEntityMetadata) = raw.getValue(19, Boolean::class.java)
    override fun writeLayingEgg(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(19, value)

    override fun readTravelPos(raw: UmpaRawEntityMetadata) = raw.getValue(20, UmpaBlockPos::class.java)
    override fun writeTravelPos(raw: UmpaRawEntityMetadata, value: UmpaBlockPos?) = raw.setValue(20, value)

    override fun readGoingHome(raw: UmpaRawEntityMetadata) = raw.getValue(21, Boolean::class.java)
    override fun writeGoingHome(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(21, value)

    override fun readTravelling(raw: UmpaRawEntityMetadata) = raw.getValue(22, Boolean::class.java)
    override fun writeTravelling(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(22, value)
}