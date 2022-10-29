package ru.melonhell.umpa.bukkit.converter

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import kotlin.reflect.KClass

interface PacketConverter {
    fun wrap(container: PacketContainer): UmpaPacket
    fun unwrap(wrapper: UmpaPacket): List<PacketContainer>
    val protocolLibTypes: Collection<PacketType>
    val wrapperType: KClass<out UmpaPacket>
}
