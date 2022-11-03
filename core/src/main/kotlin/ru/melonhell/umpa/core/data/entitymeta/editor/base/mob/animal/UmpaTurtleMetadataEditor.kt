package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAnimalMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaTurtleMetadata
import ru.melonhell.umpa.core.utils.UmpaBlockPos
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaTurtleMetadataEditor : UmpaAnimalMetadataEditor {

    fun readHomePos(raw: UmpaRawEntityMetadata): UmpaBlockPos?
    fun writeHomePos(raw: UmpaRawEntityMetadata, value: UmpaBlockPos?)

    fun readHasEgg(raw: UmpaRawEntityMetadata): Boolean?
    fun writeHasEgg(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readLayingEgg(raw: UmpaRawEntityMetadata): Boolean?
    fun writeLayingEgg(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readTravelPos(raw: UmpaRawEntityMetadata): UmpaBlockPos?
    fun writeTravelPos(raw: UmpaRawEntityMetadata, value: UmpaBlockPos?)

    fun readGoingHome(raw: UmpaRawEntityMetadata): Boolean?
    fun writeGoingHome(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readTravelling(raw: UmpaRawEntityMetadata): Boolean?
    fun writeTravelling(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaTurtleMetadata =
        UmpaTurtleMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaTurtleMetadata) return
        readHomePos(raw)?.let { meta.homePos = it }
        readHasEgg(raw)?.let { meta.hasEgg = it }
        readLayingEgg(raw)?.let { meta.layingEgg = it }
        readTravelPos(raw)?.let { meta.travelPos = it }
        readGoingHome(raw)?.let { meta.goingHome = it }
        readTravelling(raw)?.let { meta.travelling = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaTurtleMetadata) return
        writeHomePos(raw, meta.homePos)
        writeHasEgg(raw, meta.hasEgg)
        writeLayingEgg(raw, meta.layingEgg)
        writeTravelPos(raw, meta.travelPos)
        writeGoingHome(raw, meta.goingHome)
        writeTravelling(raw, meta.travelling)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaTurtleMetadata::class.java
}