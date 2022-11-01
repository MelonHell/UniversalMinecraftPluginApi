package ru.melonhell.umpa.core.data.entitymeta.reader

import net.kyori.adventure.text.Component
import ru.melonhell.umpa.core.enums.UmpaEntityPose
import java.util.*

interface UmpaEntityMetadataReader {
    var onFire: Boolean?
    var crouching: Boolean?
    var riding: Boolean?
    var sprinting: Boolean?
    var swimming: Boolean?
    var invisible: Boolean?
    var glowing: Boolean?
    var gliding: Boolean?
    var airTicks: Int?
    var customName: Optional<Component>?
    var customNameVisible: Boolean?
    var silent: Boolean?
    var noGravity: Boolean?
    var entityPose: UmpaEntityPose?
    var frozenTicks: Int?
}