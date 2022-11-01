package ru.melonhell.umpa.core.data.entitymeta.reader

import ru.melonhell.umpa.core.utils.UmpaEulerAngle

interface UmpaArmorStandMetadataReader : UmpaLivingEntityMetadataReader {
    var small: Boolean
    var hasArms: Boolean
    var noBasePlate: Boolean
    var marker: Boolean
    var headPose: UmpaEulerAngle
    var bodyPose: UmpaEulerAngle
    var leftArmPose: UmpaEulerAngle
    var rightArmPose: UmpaEulerAngle
    var leftLegPose: UmpaEulerAngle
    var rightLegPose: UmpaEulerAngle
}