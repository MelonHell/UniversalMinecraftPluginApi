package ru.melonhell.umpa.bukkit.packet.protocollib.converter.clientbound.setHealth

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.umpa.bukkit.exceptions.UmpaWrongConverterException
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.PacketConverter
import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.packet.containers.clientbound.UmpaCbSetCameraPacket
import ru.melonhell.umpa.core.packet.containers.clientbound.UmpaCbSetHealthPacket

@MinMaxMinecraftVersion("1.8", "latest")
class CbSetHealthPacketConverter_v1_8_0 : PacketConverter {
    override fun wrap(container: PacketContainer): UmpaCbSetHealthPacket {
        val health = container.float.read(0)
        val food = container.integers.read(0)
        val foodSaturation = container.float.read(1)
        return UmpaCbSetHealthPacket(health, food, foodSaturation)
    }

    override fun unwrap(wrapper: UmpaPacket): List<PacketContainer> {
        if (wrapper !is UmpaCbSetHealthPacket) throw UmpaWrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.CAMERA)
        container.float.write(0, wrapper.health)
        container.integers.write(0, wrapper.food)
        container.float.write(1, wrapper.foodSaturation)
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Server.UPDATE_HEALTH)
    override val packetType = UmpaPacketType.CB_SET_HEALTH
}