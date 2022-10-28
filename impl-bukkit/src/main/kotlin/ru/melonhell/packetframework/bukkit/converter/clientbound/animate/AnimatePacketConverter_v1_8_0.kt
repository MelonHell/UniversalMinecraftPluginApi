package ru.melonhell.packetframework.bukkit.converter.clientbound.animate

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.packetframework.bukkit.converter.PacketConverter
import ru.melonhell.packetframework.bukkit.converter.ProtocolVersion
import ru.melonhell.packetframework.bukkit.exceptions.WrongConverterException
import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.enums.EntityAnimation
import ru.melonhell.packetframework.core.protocol.game.clientbound.CbAnimatePacketWrapper

@ProtocolVersion("1.8", "latest", CbAnimatePacketWrapper::class)
class AnimatePacketConverter_v1_8_0 : PacketConverter {

    private val entityAnimations = EntityAnimation.values()

    override fun wrap(container: PacketContainer): CbAnimatePacketWrapper {
        val entityId = container.integers.read(0)
        val action = container.integers.read(1)
        return CbAnimatePacketWrapper(entityId, entityAnimations[action])
    }

    override fun unwrap(wrapper: PacketWrapper): List<PacketContainer> {
        if (wrapper !is CbAnimatePacketWrapper) throw WrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.ANIMATION)
        container.integers.write(0, wrapper.entityId)
        container.integers.write(1, wrapper.action.ordinal)
        return listOf(container)
    }

    override fun getWrapTypes() = listOf(PacketType.Play.Server.ANIMATION)
}