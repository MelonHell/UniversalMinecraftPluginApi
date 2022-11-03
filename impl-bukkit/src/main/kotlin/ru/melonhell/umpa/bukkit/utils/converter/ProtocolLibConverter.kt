package ru.melonhell.umpa.bukkit.utils.converter

import com.comphenix.protocol.wrappers.BlockPosition
import com.comphenix.protocol.wrappers.Vector3F
import com.comphenix.protocol.wrappers.WrappedChatComponent
import net.kyori.adventure.platform.bukkit.MinecraftComponentSerializer
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer
import ru.melonhell.umpa.core.utils.UmpaBlockPos
import ru.melonhell.umpa.core.utils.UmpaEulerAngle

object ProtocolLibConverter {
//    @JvmStatic
//    fun UmpaEntityMetaWrapper.protocolLib() = (this as UmpaEntityMetaWrapperProtocolLib).handle

//    @JvmStatic
//    fun List<WrappedWatchableObject>.umpa() = UmpaEntityMetaWrapperProtocolLib(this)

    @JvmStatic
    fun WrappedChatComponent.kyori() = GsonComponentSerializer.gson().deserialize(this.json)

    @JvmStatic
    fun Component.protocolLib() = WrappedChatComponent.fromJson(GsonComponentSerializer.gson().serialize(this))
    @Suppress("UnstableApiUsage")
    @JvmStatic
    fun Component.nms() = MinecraftComponentSerializer.get().serialize(this)

    @JvmStatic
    fun Vector3F.umpaEulerAngle() = UmpaEulerAngle(x, y, z)

    @JvmStatic
    fun UmpaEulerAngle.protocolLib() = Vector3F(x, y, z)
    @JvmStatic
    fun UmpaEulerAngle.nms() = Vector3F.getConverter().getGeneric(this.protocolLib())

    @JvmStatic
    fun BlockPosition.umpa() = UmpaBlockPos(x, y, z)

    @JvmStatic
    fun UmpaBlockPos.protocolLib() = BlockPosition(x, y, z)

    @JvmStatic
    fun UmpaBlockPos.nms() = BlockPosition.getConverter().getGeneric(this.protocolLib())
}