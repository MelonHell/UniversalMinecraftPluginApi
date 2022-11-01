package ru.melonhell.umpa.core.data.entitymeta

import net.kyori.adventure.text.Component
import ru.melonhell.umpa.core.enums.UmpaEntityPose

open class EntityMetadataWrapper(
    var onFire: Boolean = false,
    var crouching: Boolean = false,
    var riding: Boolean = false,
    var sprinting: Boolean = false,
    var swimming: Boolean = false,
    var invisible: Boolean = false,
    var glowing: Boolean = false,
    var gliding: Boolean = false,
    var airTicks: Int = 300,
    var customName: Component? = null,
    var customNameVisible: Boolean = false,
    var silent: Boolean = false,
    var noGravity: Boolean = false,
    var entityPose: UmpaEntityPose = UmpaEntityPose.STANDING,
    var frozenTicks: Int = 0
) : Cloneable {


    open val isEmpty: Boolean
        get() = this == empty

    override fun clone(): EntityMetadataWrapper {
        return super.clone() as EntityMetadataWrapper
    }

    companion object {
        private val empty = EntityMetadataWrapper()
    }
}