package ru.melonhell.packetframework.bukkit.converter.clientbound.playerAbilities

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import com.comphenix.protocol.wrappers.BlockPosition
import com.comphenix.protocol.wrappers.EnumWrappers
import ru.melonhell.packetframework.bukkit.converter.PacketConverter
import ru.melonhell.packetframework.bukkit.converter.ProtocolVersion
import ru.melonhell.packetframework.bukkit.exceptions.WrongConverterException
import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.protocol.game.clientbound.CbLevelEventPacketWrapper
import ru.melonhell.packetframework.core.protocol.game.clientbound.CbPlayerAbilitiesPacketWrapper
import ru.melonhell.packetframework.core.protocol.game.clientbound.CbSetCameraPacketWrapper
import ru.melonhell.packetframework.core.utils.BlockPos

@ProtocolVersion("1.8", "latest", CbPlayerAbilitiesPacketWrapper::class)
class PlayerAbilitiesPacketConverter_v1_8_0 : PacketConverter {
    override fun wrap(container: PacketContainer): CbPlayerAbilitiesPacketWrapper {
        val invulnerable = container.booleans.read(0)
        val isFlying = container.booleans.read(1)
        val canFly = container.booleans.read(2)
        val instabuild = container.booleans.read(3)
        val flyingSpeed = container.float.read(0)
        val walkingSpeed = container.float.read(1)
        return CbPlayerAbilitiesPacketWrapper(invulnerable, isFlying, canFly, instabuild, flyingSpeed, walkingSpeed)
    }

    override fun unwrap(wrapper: PacketWrapper): List<PacketContainer> {
        if (wrapper !is CbPlayerAbilitiesPacketWrapper) throw WrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.ABILITIES)
        container.booleans.write(0, wrapper.invulnerable)
        container.booleans.write(1, wrapper.isFlying)
        container.booleans.write(2, wrapper.canFly)
        container.booleans.write(3, wrapper.instabuild)
        container.float.write(0, wrapper.flyingSpeed)
        container.float.write(1, wrapper.fov)
        return listOf(container)
    }

    override fun getWrapTypes() = listOf(PacketType.Play.Server.ABILITIES)
}