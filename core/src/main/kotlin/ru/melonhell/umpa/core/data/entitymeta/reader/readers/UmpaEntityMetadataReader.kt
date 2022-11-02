package ru.melonhell.umpa.core.data.entitymeta.reader.readers

import net.kyori.adventure.text.Component
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
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

    fun read(): UmpaEntityMetadata = UmpaEntityMetadata().apply { read(this) }
    fun read(meta: UmpaEntityMetadata) {
        onFire?.let { meta.onFire = it }
        crouching?.let { meta.crouching = it }
        riding?.let { meta.riding = it }
        sprinting?.let { meta.sprinting = it }
        swimming?.let { meta.swimming = it }
        invisible?.let { meta.invisible = it }
        glowing?.let { meta.glowing = it }
        gliding?.let { meta.gliding = it }
        airTicks?.let { meta.airTicks = it }
        customName?.let { meta.customName = it }
        customNameVisible?.let { meta.customNameVisible = it }
        silent?.let { meta.silent = it }
        noGravity?.let { meta.noGravity = it }
        entityPose?.let { meta.entityPose = it }
        frozenTicks?.let { meta.frozenTicks = it }
    }

    fun apply(meta: UmpaEntityMetadata) {
        onFire = meta.onFire
        crouching = meta.crouching
        riding = meta.riding
        sprinting = meta.sprinting
        swimming = meta.swimming
        invisible = meta.invisible
        glowing = meta.glowing
        gliding = meta.gliding
        airTicks = meta.airTicks
        customName = meta.customName
        customNameVisible = meta.customNameVisible
        silent = meta.silent
        noGravity = meta.noGravity
        entityPose = meta.entityPose
        frozenTicks = meta.frozenTicks
    }
}