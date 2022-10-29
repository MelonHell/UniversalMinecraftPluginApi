package ru.melonhell.umpa.bukkit.packet.protocollib.converter.clientbound.entityAnimate

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.PacketConverter
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.ProtocolVersion
import ru.melonhell.umpa.bukkit.exceptions.UmpaWrongConverterException
import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.packet.containers.clientbound.UmpaCbEntityAnimatePacket

@ProtocolVersion("1.8", "latest")
class CbEntityAnimatePacketConverter_v1_8_0 : PacketConverter {
    private val entityAnimations = UmpaCbEntityAnimatePacket.EntityAnimation.values()

    override fun wrap(container: PacketContainer): UmpaCbEntityAnimatePacket {
        val entityId = container.integers.read(0)
        val action = container.integers.read(1)
        return UmpaCbEntityAnimatePacket(entityId, entityAnimations[action])
    }

    override fun unwrap(wrapper: UmpaPacket): List<PacketContainer> {
        if (wrapper !is UmpaCbEntityAnimatePacket) throw UmpaWrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.ANIMATION)
        container.integers.write(0, wrapper.entityId)
        container.integers.write(1, wrapper.action.ordinal)
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Server.ANIMATION)
    override val packetType = UmpaPacketType.CB_ENTITY_ANIMATE
}