package ru.melonhell.umpa.core.data.entitymeta.meta

import net.kyori.adventure.text.Component
import ru.melonhell.umpa.core.enums.UmpaEntityPose
import java.util.*

open class UmpaEntityMetadata(
    var onFire: Boolean = false,
    var crouching: Boolean = false,
    var riding: Boolean = false,
    var sprinting: Boolean = false,
    var swimming: Boolean = false,
    var invisible: Boolean = false,
    var glowing: Boolean = false,
    var gliding: Boolean = false,
    var airTicks: Int = 300,
    var customName: Optional<Component> = Optional.empty(),
    var customNameVisible: Boolean = false,
    var silent: Boolean = false,
    var noGravity: Boolean = false,
    var entityPose: UmpaEntityPose = UmpaEntityPose.STANDING,
    var frozenTicks: Int = 0
) : Cloneable {
    open val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaEntityMetadata {
        return super.clone() as UmpaEntityMetadata
    }

    companion object {
        private val empty = UmpaEntityMetadata()
    }
}