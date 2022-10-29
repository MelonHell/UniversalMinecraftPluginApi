package ru.melonhell.umpa.bukkit.converter.clientbound.animate

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.umpa.bukkit.converter.PacketConverter
import ru.melonhell.umpa.bukkit.converter.ProtocolVersion
import ru.melonhell.umpa.bukkit.exceptions.WrongConverterException
import ru.melonhell.umpa.core.protocol.game.clientbound.CbAnimatePacketWrapper

@ProtocolVersion("1.8", "latest")
class AnimatePacketConverter_v1_8_0 : PacketConverter {
    private val entityAnimations = ru.melonhell.umpa.core.enums.EntityAnimation.values()

    override fun wrap(container: PacketContainer): CbAnimatePacketWrapper {
        val entityId = container.integers.read(0)
        val action = container.integers.read(1)
        return CbAnimatePacketWrapper(entityId, entityAnimations[action])
    }

    override fun unwrap(wrapper: ru.melonhell.umpa.core.PacketWrapper): List<PacketContainer> {
        if (wrapper !is CbAnimatePacketWrapper) throw WrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.ANIMATION)
        container.integers.write(0, wrapper.entityId)
        container.integers.write(1, wrapper.action.ordinal)
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Server.ANIMATION)
    override val wrapperType = CbAnimatePacketWrapper::class
}