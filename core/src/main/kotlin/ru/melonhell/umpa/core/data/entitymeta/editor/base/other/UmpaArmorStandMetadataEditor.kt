package ru.melonhell.umpa.core.data.entitymeta.editor.base.other

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaLivingEntityMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaArmorStandMetadata
import ru.melonhell.umpa.core.utils.UmpaEulerAngle
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaArmorStandMetadataEditor : UmpaLivingEntityMetadataEditor {

    fun readSmall(raw: UmpaRawEntityMetadata): Boolean?
    fun writeSmall(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readHasArms(raw: UmpaRawEntityMetadata): Boolean?
    fun writeHasArms(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readNoBasePlate(raw: UmpaRawEntityMetadata): Boolean?
    fun writeNoBasePlate(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readMarker(raw: UmpaRawEntityMetadata): Boolean?
    fun writeMarker(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readHeadPose(raw: UmpaRawEntityMetadata): UmpaEulerAngle?
    fun writeHeadPose(raw: UmpaRawEntityMetadata, value: UmpaEulerAngle?)

    fun readBodyPose(raw: UmpaRawEntityMetadata): UmpaEulerAngle?
    fun writeBodyPose(raw: UmpaRawEntityMetadata, value: UmpaEulerAngle?)

    fun readLeftArmPose(raw: UmpaRawEntityMetadata): UmpaEulerAngle?
    fun writeLeftArmPose(raw: UmpaRawEntityMetadata, value: UmpaEulerAngle?)

    fun readRightArmPose(raw: UmpaRawEntityMetadata): UmpaEulerAngle?
    fun writeRightArmPose(raw: UmpaRawEntityMetadata, value: UmpaEulerAngle?)

    fun readLeftLegPose(raw: UmpaRawEntityMetadata): UmpaEulerAngle?
    fun writeLeftLegPose(raw: UmpaRawEntityMetadata, value: UmpaEulerAngle?)

    fun readRightLegPose(raw: UmpaRawEntityMetadata): UmpaEulerAngle?
    fun writeRightLegPose(raw: UmpaRawEntityMetadata, value: UmpaEulerAngle?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaArmorStandMetadata =
        UmpaArmorStandMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaArmorStandMetadata) return
        readSmall(raw)?.let { meta.small = it }
        readHasArms(raw)?.let { meta.hasArms = it }
        readNoBasePlate(raw)?.let { meta.noBasePlate = it }
        readMarker(raw)?.let { meta.marker = it }
        readHeadPose(raw)?.let { meta.headPose = it }
        readBodyPose(raw)?.let { meta.bodyPose = it }
        readLeftArmPose(raw)?.let { meta.leftArmPose = it }
        readRightArmPose(raw)?.let { meta.rightArmPose = it }
        readLeftLegPose(raw)?.let { meta.leftLegPose = it }
        readRightLegPose(raw)?.let { meta.rightLegPose = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaArmorStandMetadata) return
        writeSmall(raw, meta.small)
        writeHasArms(raw, meta.hasArms)
        writeNoBasePlate(raw, meta.noBasePlate)
        writeMarker(raw, meta.marker)
        writeHeadPose(raw, meta.headPose)
        writeBodyPose(raw, meta.bodyPose)
        writeLeftArmPose(raw, meta.leftArmPose)
        writeRightArmPose(raw, meta.rightArmPose)
        writeLeftLegPose(raw, meta.leftLegPose)
        writeRightLegPose(raw, meta.rightLegPose)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaArmorStandMetadata::class.java
}