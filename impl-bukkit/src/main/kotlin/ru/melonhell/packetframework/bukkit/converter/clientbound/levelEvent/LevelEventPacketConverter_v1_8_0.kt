package ru.melonhell.packetframework.bukkit.converter.clientbound.levelEvent

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import com.comphenix.protocol.wrappers.BlockPosition
import ru.melonhell.packetframework.bukkit.converter.PacketConverter
import ru.melonhell.packetframework.bukkit.converter.ProtocolVersion
import ru.melonhell.packetframework.bukkit.exceptions.WrongConverterException
import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.protocol.game.clientbound.CbLevelEventPacketWrapper
import ru.melonhell.packetframework.core.utils.BlockPos

@ProtocolVersion("1.8", "latest")
class LevelEventPacketConverter_v1_8_0 : PacketConverter {
    override fun wrap(container: PacketContainer): CbLevelEventPacketWrapper {
        val type = container.integers.read(0)
        val blockPosProtocolLib = container.blockPositionModifier.read(0)
        val pos = BlockPos(blockPosProtocolLib.x, blockPosProtocolLib.y, blockPosProtocolLib.z)
        val data = container.integers.read(1)
        val global = container.booleans.read(0)
        return CbLevelEventPacketWrapper(type, pos, data, global)
    }

    override fun unwrap(wrapper: PacketWrapper): List<PacketContainer> {
        if (wrapper !is CbLevelEventPacketWrapper) throw WrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.WORLD_EVENT)
        container.integers.write(0, wrapper.type)
        container.blockPositionModifier.write(0, BlockPosition(wrapper.pos.x, wrapper.pos.y, wrapper.pos.z))
        container.integers.write(1, wrapper.data)
        container.booleans.write(0, wrapper.global)
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Server.WORLD_EVENT)
    override val wrapperType = CbLevelEventPacketWrapper::class
}