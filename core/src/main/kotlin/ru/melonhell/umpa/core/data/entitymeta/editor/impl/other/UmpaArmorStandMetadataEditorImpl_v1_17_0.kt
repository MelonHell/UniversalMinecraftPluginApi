package ru.melonhell.umpa.core.data.entitymeta.editor.impl.other

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.other.UmpaArmorStandMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaLivingEntityMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.utils.UmpaEulerAngle
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaArmorStandMetadataEditorImpl_v1_17_0 : UmpaArmorStandMetadataEditor,
    UmpaLivingEntityMetadataEditorImpl_v1_17_0() {
    override fun readSmall(raw: UmpaRawEntityMetadata) = raw.readFlag(15, 0)
    override fun writeSmall(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(15, 0, value)

    override fun readHasArms(raw: UmpaRawEntityMetadata) = raw.readFlag(15, 2)
    override fun writeHasArms(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(15, 2, value)

    override fun readNoBasePlate(raw: UmpaRawEntityMetadata) = raw.readFlag(15, 3)
    override fun writeNoBasePlate(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(15, 3, value)

    override fun readMarker(raw: UmpaRawEntityMetadata) = raw.readFlag(15, 4)
    override fun writeMarker(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(15, 4, value)

    override fun readHeadPose(raw: UmpaRawEntityMetadata) = raw.readValue(16, UmpaEulerAngle::class.java)
    override fun writeHeadPose(raw: UmpaRawEntityMetadata, value: UmpaEulerAngle?) = raw.writeValue(16, value, UmpaEulerAngle::class.java)

    override fun readBodyPose(raw: UmpaRawEntityMetadata) = raw.readValue(17, UmpaEulerAngle::class.java)
    override fun writeBodyPose(raw: UmpaRawEntityMetadata, value: UmpaEulerAngle?) = raw.writeValue(17, value, UmpaEulerAngle::class.java)

    override fun readLeftArmPose(raw: UmpaRawEntityMetadata) = raw.readValue(18, UmpaEulerAngle::class.java)
    override fun writeLeftArmPose(raw: UmpaRawEntityMetadata, value: UmpaEulerAngle?) = raw.writeValue(18, value, UmpaEulerAngle::class.java)

    override fun readRightArmPose(raw: UmpaRawEntityMetadata) = raw.readValue(19, UmpaEulerAngle::class.java)
    override fun writeRightArmPose(raw: UmpaRawEntityMetadata, value: UmpaEulerAngle?) = raw.writeValue(19, value, UmpaEulerAngle::class.java)

    override fun readLeftLegPose(raw: UmpaRawEntityMetadata) = raw.readValue(20, UmpaEulerAngle::class.java)
    override fun writeLeftLegPose(raw: UmpaRawEntityMetadata, value: UmpaEulerAngle?) = raw.writeValue(20, value, UmpaEulerAngle::class.java)

    override fun readRightLegPose(raw: UmpaRawEntityMetadata) = raw.readValue(21, UmpaEulerAngle::class.java)
    override fun writeRightLegPose(raw: UmpaRawEntityMetadata, value: UmpaEulerAngle?) = raw.writeValue(21, value, UmpaEulerAngle::class.java)
}