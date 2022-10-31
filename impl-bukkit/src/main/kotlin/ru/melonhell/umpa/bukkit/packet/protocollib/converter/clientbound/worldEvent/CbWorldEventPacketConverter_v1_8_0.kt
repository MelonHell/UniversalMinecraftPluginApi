package ru.melonhell.umpa.bukkit.packet.protocollib.converter.clientbound.worldEvent

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import com.comphenix.protocol.wrappers.BlockPosition
import ru.melonhell.umpa.bukkit.exceptions.UmpaWrongConverterException
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.PacketConverter
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.ProtocolVersion
import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.packet.containers.clientbound.UmpaCbWorldEventPacket
import ru.melonhell.umpa.core.utils.UmpaBlockPos

@ProtocolVersion("1.8", "latest")
class CbWorldEventPacketConverter_v1_8_0 : PacketConverter {
    override fun wrap(container: PacketContainer): UmpaCbWorldEventPacket {
        val type = container.integers.read(0)
        val blockPosProtocolLib = container.blockPositionModifier.read(0)
        val pos = UmpaBlockPos(blockPosProtocolLib.x, blockPosProtocolLib.y, blockPosProtocolLib.z)
        val data = container.integers.read(1)
        val global = container.booleans.read(0)
        return UmpaCbWorldEventPacket(type, pos, data, global)
    }

    override fun unwrap(wrapper: UmpaPacket): List<PacketContainer> {
        if (wrapper !is UmpaCbWorldEventPacket) throw UmpaWrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.WORLD_EVENT)
        container.integers.write(0, wrapper.type)
        container.blockPositionModifier.write(0, BlockPosition(wrapper.pos.x, wrapper.pos.y, wrapper.pos.z))
        container.integers.write(1, wrapper.data)
        container.booleans.write(0, wrapper.global)
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Server.WORLD_EVENT)
    override val packetType = UmpaPacketType.CB_WORLD_EVENT
}