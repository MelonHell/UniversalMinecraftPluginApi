package ru.melonhell.umpa.core.data.entitymeta

import ru.melonhell.umpa.core.utils.UmpaEulerAngle

class ArmorStandMetadataWrapper(
    var small: Boolean = false,
    var hasArms: Boolean = false,
    var noBasePlate: Boolean = false,
    var marker: Boolean = false,
    var headPose: UmpaEulerAngle = UmpaEulerAngle(),
    var bodyPose: UmpaEulerAngle = UmpaEulerAngle(),
    var leftArmPose: UmpaEulerAngle = UmpaEulerAngle(Math.toRadians(-10.0), 0.0, Math.toRadians(-10.0)),
    var rightArmPose: UmpaEulerAngle = UmpaEulerAngle(Math.toRadians(-15.0), 0.0, Math.toRadians(10.0)),
    var leftLegPose: UmpaEulerAngle = UmpaEulerAngle(Math.toRadians(-1.0), 0.0, Math.toRadians(-1.0)),
    var rightLegPose: UmpaEulerAngle = UmpaEulerAngle(Math.toRadians(1.0), 0.0, Math.toRadians(1.0))
) : LivingEntityMetadataWrapper() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): ArmorStandMetadataWrapper {
        return super.clone() as ArmorStandMetadataWrapper
    }

    companion object {
        private val empty = ArmorStandMetadataWrapper()
    }
}