package ru.melonhell.umpa.bukkit.entitymeta.reader.entity

import com.comphenix.protocol.wrappers.EnumWrappers.EntityPose
import com.comphenix.protocol.wrappers.WrappedChatComponent
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer
import ru.melonhell.umpa.bukkit.utils.ProtocolLibUtils
import ru.melonhell.umpa.bukkit.utils.converter.ProtocolLibEnumConverter.protocolLib
import ru.melonhell.umpa.bukkit.utils.converter.ProtocolLibEnumConverter.umpa
import ru.melonhell.umpa.bukkit.wrappers.UmpaEntityMetaWrapperProtocolLib
import ru.melonhell.umpa.core.data.entitymeta.reader.UmpaEntityMetadataReader
import ru.melonhell.umpa.core.enums.UmpaEntityPose
import java.util.*
import kotlin.jvm.optionals.getOrNull

@Suppress("UNCHECKED_CAST")
class UmpaEntityMetadataReader_v1_17_0(metadata: UmpaEntityMetaWrapperProtocolLib) : UmpaEntityMetadataReader {
    private val metaMap = metadata.handle

    private var flags: Byte?
        get() = metaMap[0]?.value as Byte?
        set(value) {
            if (value == null) metaMap.remove(0)
            else metaMap[0] = ProtocolLibUtils.wrapMetaObject(0, value)
        }

    override var onFire: Boolean?
        get() = flags?.let { ProtocolLibUtils.getSharedFlag(it, 0) }
        set(value) {
            if (value != null) ProtocolLibUtils.setSharedFlag(flags ?: 0, 0, value)
        }
    override var crouching: Boolean?
        get() = flags?.let { ProtocolLibUtils.getSharedFlag(it, 1) }
        set(value) {
            if (value != null) ProtocolLibUtils.setSharedFlag(flags ?: 1, 1, value)
        }
    override var riding: Boolean?
        get() = flags?.let { ProtocolLibUtils.getSharedFlag(it, 2) }
        set(value) {
            if (value != null) ProtocolLibUtils.setSharedFlag(flags ?: 0, 2, value)
        }
    override var sprinting: Boolean?
        get() = flags?.let { ProtocolLibUtils.getSharedFlag(it, 3) }
        set(value) {
            if (value != null) ProtocolLibUtils.setSharedFlag(flags ?: 0, 3, value)
        }
    override var swimming: Boolean?
        get() = flags?.let { ProtocolLibUtils.getSharedFlag(it, 4) }
        set(value) {
            if (value != null) ProtocolLibUtils.setSharedFlag(flags ?: 0, 4, value)
        }
    override var invisible: Boolean?
        get() = flags?.let { ProtocolLibUtils.getSharedFlag(it, 5) }
        set(value) {
            if (value != null) ProtocolLibUtils.setSharedFlag(flags ?: 0, 5, value)
        }
    override var glowing: Boolean?
        get() = flags?.let { ProtocolLibUtils.getSharedFlag(it, 6) }
        set(value) {
            if (value != null) ProtocolLibUtils.setSharedFlag(flags ?: 0, 6, value)
        }
    override var gliding: Boolean?
        get() = flags?.let { ProtocolLibUtils.getSharedFlag(it, 7) }
        set(value) {
            if (value != null) ProtocolLibUtils.setSharedFlag(flags ?: 0, 7, value)
        }
    override var airTicks: Int?
        get() = metaMap[1]?.value as Int?
        set(value) {
            if (value == null) metaMap.remove(1)
            else metaMap[1] = ProtocolLibUtils.wrapMetaObject(1, value)
        }

    @OptIn(ExperimentalStdlibApi::class)
    override var customName: Optional<Component>?
        get() = (metaMap[2]?.value as Optional<WrappedChatComponent>?)?.map {
            GsonComponentSerializer.gson().deserialize(it.json)
        }
        set(value) {
            if (value == null) metaMap.remove(2)
            else metaMap[2] = ProtocolLibUtils.wrapMetaOptional(2, value.getOrNull(), Component::class.java)
        }
    override var customNameVisible: Boolean?
        get() = metaMap[3]?.value as Boolean?
        set(value) {
            if (value == null) metaMap.remove(3)
            else metaMap[3] = ProtocolLibUtils.wrapMetaObject(3, value)
        }
    override var silent: Boolean?
        get() = metaMap[4]?.value as Boolean?
        set(value) {
            if (value == null) metaMap.remove(4)
            else metaMap[4] = ProtocolLibUtils.wrapMetaObject(4, value)
        }
    override var noGravity: Boolean?
        get() = metaMap[5]?.value as Boolean?
        set(value) {
            if (value == null) metaMap.remove(5)
            else metaMap[5] = ProtocolLibUtils.wrapMetaObject(5, value)
        }
    override var entityPose: UmpaEntityPose?
        get() = metaMap[6]?.value?.let { EntityPose.fromNms(it) }?.umpa()
        set(value) {
            if (value == null) metaMap.remove(6)
            else metaMap[6] = ProtocolLibUtils.wrapMetaObject(6, value.protocolLib())
        }
    override var frozenTicks: Int?
        get() = metaMap[7]?.value as Int?
        set(value) {
            if (value == null) metaMap.remove(7)
            else metaMap[7] = ProtocolLibUtils.wrapMetaObject(7, value)
        }
}