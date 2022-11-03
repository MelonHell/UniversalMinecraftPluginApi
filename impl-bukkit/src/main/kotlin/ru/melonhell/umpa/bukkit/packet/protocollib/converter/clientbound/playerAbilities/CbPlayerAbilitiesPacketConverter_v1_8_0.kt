package ru.melonhell.umpa.bukkit.packet.protocollib.converter.clientbound.playerAbilities

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.umpa.bukkit.exceptions.UmpaWrongConverterException
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.PacketConverter
import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.packet.containers.clientbound.UmpaCbPlayerAbilitiesPacket

@MinMaxMinecraftVersion("1.8", "latest")
class CbPlayerAbilitiesPacketConverter_v1_8_0 : PacketConverter {
    override fun wrap(container: PacketContainer): UmpaCbPlayerAbilitiesPacket {
        val invulnerable = container.booleans.read(0)
        val isFlying = container.booleans.read(1)
        val canFly = container.booleans.read(2)
        val instabuild = container.booleans.read(3)
        val flyingSpeed = container.float.read(0)
        val walkingSpeed = container.float.read(1)
        return UmpaCbPlayerAbilitiesPacket(invulnerable, isFlying, canFly, instabuild, flyingSpeed, walkingSpeed)
    }

    override fun unwrap(wrapper: UmpaPacket): List<PacketContainer> {
        if (wrapper !is UmpaCbPlayerAbilitiesPacket) throw UmpaWrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.ABILITIES)
        container.booleans.write(0, wrapper.invulnerable)
        container.booleans.write(1, wrapper.isFlying)
        container.booleans.write(2, wrapper.canFly)
        container.booleans.write(3, wrapper.instabuild)
        container.float.write(0, wrapper.flyingSpeed)
        container.float.write(1, wrapper.fov)
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Server.ABILITIES)
    override val packetType = UmpaPacketType.CB_PLAYER_ABILITIES
}