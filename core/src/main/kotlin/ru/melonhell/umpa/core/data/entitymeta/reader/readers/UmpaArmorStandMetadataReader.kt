package ru.melonhell.umpa.core.data.entitymeta.reader.readers

import ru.melonhell.umpa.core.data.entitymeta.UmpaArmorStandMetadata
import ru.melonhell.umpa.core.data.entitymeta.UmpaEntityMetadata
import ru.melonhell.umpa.core.utils.UmpaEulerAngle

interface UmpaArmorStandMetadataReader : UmpaLivingEntityMetadataReader {
    var small: Boolean?
    var hasArms: Boolean?
    var noBasePlate: Boolean?
    var marker: Boolean?
    var headPose: UmpaEulerAngle?
    var bodyPose: UmpaEulerAngle?
    var leftArmPose: UmpaEulerAngle?
    var rightArmPose: UmpaEulerAngle?
    var leftLegPose: UmpaEulerAngle?
    var rightLegPose: UmpaEulerAngle?

    override fun read(): UmpaArmorStandMetadata = UmpaArmorStandMetadata().apply { read(this) }

    override fun read(meta: UmpaEntityMetadata) {
        super.read(meta)
        if (meta !is UmpaArmorStandMetadata) return
        small?.let { meta.small = it }
        hasArms?.let { meta.hasArms = it }
        noBasePlate?.let { meta.noBasePlate = it }
        marker?.let { meta.marker = it }
        headPose?.let { meta.headPose = it }
        bodyPose?.let { meta.bodyPose = it }
        leftArmPose?.let { meta.leftArmPose = it }
        rightArmPose?.let { meta.rightArmPose = it }
        leftLegPose?.let { meta.leftLegPose = it }
        rightLegPose?.let { meta.rightLegPose = it }
    }

    override fun apply(meta: UmpaEntityMetadata) {
        super.apply(meta)
        if (meta !is UmpaArmorStandMetadata) return
        small = meta.small
        hasArms = meta.hasArms
        noBasePlate = meta.noBasePlate
        marker = meta.marker
        headPose = meta.headPose
        bodyPose = meta.bodyPose
        leftArmPose = meta.leftArmPose
        rightArmPose = meta.rightArmPose
        leftLegPose = meta.leftLegPose
        rightLegPose = meta.rightLegPose
    }
}