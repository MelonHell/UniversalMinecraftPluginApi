package ru.melonhell.umpa.bukkit.packet.protocollib.converter

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket

interface PacketConverter {
    fun wrap(container: PacketContainer): UmpaPacket
    fun unwrap(wrapper: UmpaPacket): List<PacketContainer>
    val packetType: UmpaPacketType
    val protocolLibTypes: Collection<PacketType>
}
