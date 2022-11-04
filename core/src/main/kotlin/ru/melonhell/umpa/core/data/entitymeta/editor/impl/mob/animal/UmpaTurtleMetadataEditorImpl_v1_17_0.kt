package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaTurtleMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAnimalMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.utils.UmpaBlockPos
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaTurtleMetadataEditorImpl_v1_17_0 : UmpaTurtleMetadataEditor, UmpaAnimalMetadataEditorImpl_v1_17_0() {
    override fun readHomePos(raw: UmpaRawEntityMetadata) = raw.readValue(17, UmpaBlockPos::class.java)
    override fun writeHomePos(raw: UmpaRawEntityMetadata, value: UmpaBlockPos?) = raw.writeValue(17, value, UmpaBlockPos::class.java)

    override fun readHasEgg(raw: UmpaRawEntityMetadata) = raw.readValue(18, Boolean::class.java)
    override fun writeHasEgg(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(18, value, Boolean::class.java)

    override fun readLayingEgg(raw: UmpaRawEntityMetadata) = raw.readValue(19, Boolean::class.java)
    override fun writeLayingEgg(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(19, value, Boolean::class.java)

    override fun readTravelPos(raw: UmpaRawEntityMetadata) = raw.readValue(20, UmpaBlockPos::class.java)
    override fun writeTravelPos(raw: UmpaRawEntityMetadata, value: UmpaBlockPos?) = raw.writeValue(20, value, UmpaBlockPos::class.java)

    override fun readGoingHome(raw: UmpaRawEntityMetadata) = raw.readValue(21, Boolean::class.java)
    override fun writeGoingHome(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(21, value, Boolean::class.java)

    override fun readTravelling(raw: UmpaRawEntityMetadata) = raw.readValue(22, Boolean::class.java)
    override fun writeTravelling(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(22, value, Boolean::class.java)
}