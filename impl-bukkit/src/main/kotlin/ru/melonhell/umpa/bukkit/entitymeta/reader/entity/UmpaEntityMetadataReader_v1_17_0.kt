package ru.melonhell.umpa.bukkit.entitymeta.reader.entity

import com.comphenix.protocol.wrappers.EnumWrappers.EntityPose
import net.kyori.adventure.text.Component
import ru.melonhell.umpa.bukkit.utils.converter.ProtocolLibEnumConverter.umpa
import ru.melonhell.umpa.bukkit.wrappers.UmpaRawEntityMetadataProtocolLib
import ru.melonhell.umpa.core.data.entitymeta.reader.readers.UmpaEntityMetadataReader
import ru.melonhell.umpa.core.enums.UmpaEntityPose
import java.util.*

open class UmpaEntityMetadataReader_v1_17_0(private val meta: UmpaRawEntityMetadataProtocolLib) :
    UmpaEntityMetadataReader {

    override var onFire: Boolean?
        get() = meta.getFlag(0, 0)
        set(value) = meta.setFlag(0, 0, value)
    override var crouching: Boolean?
        get() = meta.getFlag(0, 1)
        set(value) = meta.setFlag(0, 1, value)
    override var riding: Boolean?
        get() = meta.getFlag(0, 2)
        set(value) = meta.setFlag(0, 2, value)
    override var sprinting: Boolean?
        get() = meta.getFlag(0, 3)
        set(value) = meta.setFlag(0, 3, value)
    override var swimming: Boolean?
        get() = meta.getFlag(0, 4)
        set(value) = meta.setFlag(0, 4, value)
    override var invisible: Boolean?
        get() = meta.getFlag(0, 5)
        set(value) = meta.setFlag(0, 5, value)
    override var glowing: Boolean?
        get() = meta.getFlag(0, 6)
        set(value) = meta.setFlag(0, 6, value)
    override var gliding: Boolean?
        get() = meta.getFlag(0, 7)
        set(value) = meta.setFlag(0, 7, value)
    override var airTicks: Int?
        get() = meta.handle[1]?.value as Int?
        set(value) = meta.setValue(1, value)
    override var customName: Optional<Component>?
        get() = meta.getOptionalComponent(2)
        set(value) = meta.setOptional(2, value, Component::class.java)
    override var customNameVisible: Boolean?
        get() = meta.getRawValue(3)
        set(value) = meta.setValue(3, value)
    override var silent: Boolean?
        get() = meta.getRawValue(4)
        set(value) = meta.setValue(4, value)
    override var noGravity: Boolean?
        get() = meta.getRawValue(5)
        set(value) = meta.setValue(5, value)
    override var entityPose: UmpaEntityPose?
        get() = meta.handle[6]?.value?.let { EntityPose.fromNms(it) }?.umpa()
        set(value) = meta.setValue(6, value)
    override var frozenTicks: Int?
        get() = meta.getRawValue(7)
        set(value) = meta.setValue(7, value)
}