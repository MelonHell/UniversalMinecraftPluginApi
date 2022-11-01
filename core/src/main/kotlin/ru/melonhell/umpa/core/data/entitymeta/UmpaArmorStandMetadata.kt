package ru.melonhell.umpa.core.data.entitymeta

import ru.melonhell.umpa.core.utils.UmpaEulerAngle

class UmpaArmorStandMetadata(
    var small: Boolean = false,
    var hasArms: Boolean = false,
    var noBasePlate: Boolean = false,
    var marker: Boolean = false,
    var headPose: UmpaEulerAngle = UmpaEulerAngle(),
    var bodyPose: UmpaEulerAngle = UmpaEulerAngle(),
    var leftArmPose: UmpaEulerAngle = UmpaEulerAngle(-10f, 0f, -10f),
    var rightArmPose: UmpaEulerAngle = UmpaEulerAngle(-15f, 0f, 10f),
    var leftLegPose: UmpaEulerAngle = UmpaEulerAngle(-1f, 0f, -1f),
    var rightLegPose: UmpaEulerAngle = UmpaEulerAngle(1f, 0f, 1f)
) : UmpaLivingEntityMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaArmorStandMetadata {
        return super.clone() as UmpaArmorStandMetadata
    }

    companion object {
        private val empty = UmpaArmorStandMetadata()
    }
}