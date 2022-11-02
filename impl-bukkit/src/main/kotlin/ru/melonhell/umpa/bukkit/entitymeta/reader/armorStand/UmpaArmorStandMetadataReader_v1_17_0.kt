package ru.melonhell.umpa.bukkit.entitymeta.reader.armorStand

import ru.melonhell.umpa.bukkit.entitymeta.reader.livingEntity.UmpaLivingEntityMetadataReader_v1_17_0
import ru.melonhell.umpa.bukkit.wrappers.UmpaRawEntityMetadataProtocolLib
import ru.melonhell.umpa.core.data.entitymeta.editor.readers.UmpaArmorStandMetadataReader
import ru.melonhell.umpa.core.utils.UmpaEulerAngle

class UmpaArmorStandMetadataReader_v1_17_0(private val meta: UmpaRawEntityMetadataProtocolLib) :
    UmpaLivingEntityMetadataReader_v1_17_0(meta), UmpaArmorStandMetadataReader {

    override var small: Boolean?
        get() = meta.getFlag(15, 0)
        set(value) = meta.setFlag(15, 0, value)
    override var hasArms: Boolean?
        get() = meta.getFlag(15, 2)
        set(value) = meta.setFlag(15, 2, value)
    override var noBasePlate: Boolean?
        get() = meta.getFlag(15, 3)
        set(value) = meta.setFlag(15, 3, value)
    override var marker: Boolean?
        get() = meta.getFlag(15, 4)
        set(value) = meta.setFlag(15, 4, value)
    override var headPose: UmpaEulerAngle?
        get() = meta.getEulerAngle(16)
        set(value) = meta.setValue(16, value)
    override var bodyPose: UmpaEulerAngle?
        get() = meta.getEulerAngle(17)
        set(value) = meta.setValue(17, value)
    override var leftArmPose: UmpaEulerAngle?
        get() = meta.getEulerAngle(18)
        set(value) = meta.setValue(18, value)
    override var rightArmPose: UmpaEulerAngle?
        get() = meta.getEulerAngle(19)
        set(value) = meta.setValue(19, value)
    override var leftLegPose: UmpaEulerAngle?
        get() = meta.getEulerAngle(20)
        set(value) = meta.setValue(20, value)
    override var rightLegPose: UmpaEulerAngle?
        get() = meta.getEulerAngle(21)
        set(value) = meta.setValue(21, value)
}