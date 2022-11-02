package ru.melonhell.umpa.core.data.entitymeta.editor

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaPlayerMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaLivingEntityMetadataEditor
import ru.melonhell.umpa.core.utils.UmpaCompoundTag
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaPlayerMetadataEditor : UmpaLivingEntityMetadataEditor {

    fun readPlayerAbsorption(raw: UmpaRawEntityMetadata): Float?
    fun writePlayerAbsorption(raw: UmpaRawEntityMetadata, value: Float?)

    fun readScore(raw: UmpaRawEntityMetadata): Int?
    fun writeScore(raw: UmpaRawEntityMetadata, value: Int?)

    fun readShowCape(raw: UmpaRawEntityMetadata): Boolean?
    fun writeShowCape(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readShowJacket(raw: UmpaRawEntityMetadata): Boolean?
    fun writeShowJacket(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readShowLeftSleeve(raw: UmpaRawEntityMetadata): Boolean?
    fun writeShowLeftSleeve(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readShowRightSleeve(raw: UmpaRawEntityMetadata): Boolean?
    fun writeShowRightSleeve(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readShowLeftPantsLeg(raw: UmpaRawEntityMetadata): Boolean?
    fun writeShowLeftPantsLeg(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readShowRightPantsLeg(raw: UmpaRawEntityMetadata): Boolean?
    fun writeShowRightPantsLeg(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readShowHat(raw: UmpaRawEntityMetadata): Boolean?
    fun writeShowHat(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readLeftHanded(raw: UmpaRawEntityMetadata): Boolean?
    fun writeLeftHanded(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readShoulderLeft(raw: UmpaRawEntityMetadata): UmpaCompoundTag?
    fun writeShoulderLeft(raw: UmpaRawEntityMetadata, value: UmpaCompoundTag?)

    fun readShoulderRight(raw: UmpaRawEntityMetadata): UmpaCompoundTag?
    fun writeShoulderRight(raw: UmpaRawEntityMetadata, value: UmpaCompoundTag?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaPlayerMetadata =
        UmpaPlayerMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaPlayerMetadata) return
        readPlayerAbsorption(raw)?.let { meta.playerAbsorption = it }
        readScore(raw)?.let { meta.score = it }
        readShowCape(raw)?.let { meta.showCape = it }
        readShowJacket(raw)?.let { meta.showJacket = it }
        readShowLeftSleeve(raw)?.let { meta.showLeftSleeve = it }
        readShowRightSleeve(raw)?.let { meta.showRightSleeve = it }
        readShowLeftPantsLeg(raw)?.let { meta.showLeftPantsLeg = it }
        readShowRightPantsLeg(raw)?.let { meta.showRightPantsLeg = it }
        readShowHat(raw)?.let { meta.showHat = it }
        readLeftHanded(raw)?.let { meta.leftHanded = it }
        readShoulderLeft(raw)?.let { meta.shoulderLeft = it }
        readShoulderRight(raw)?.let { meta.shoulderRight = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaPlayerMetadata) return
        writePlayerAbsorption(raw, meta.playerAbsorption)
        writeScore(raw, meta.score)
        writeShowCape(raw, meta.showCape)
        writeShowJacket(raw, meta.showJacket)
        writeShowLeftSleeve(raw, meta.showLeftSleeve)
        writeShowRightSleeve(raw, meta.showRightSleeve)
        writeShowLeftPantsLeg(raw, meta.showLeftPantsLeg)
        writeShowRightPantsLeg(raw, meta.showRightPantsLeg)
        writeShowHat(raw, meta.showHat)
        writeLeftHanded(raw, meta.leftHanded)
        writeShoulderLeft(raw, meta.shoulderLeft)
        writeShoulderRight(raw, meta.shoulderRight)
    }
}