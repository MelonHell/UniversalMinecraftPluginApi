package ru.melonhell.umpa.bukkit.converter

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.umpa.core.packet.containers.UmpaPacketContainer
import kotlin.reflect.KClass

interface PacketConverter {
    fun wrap(container: PacketContainer): UmpaPacketContainer
    fun unwrap(wrapper: UmpaPacketContainer): List<PacketContainer>
    val protocolLibTypes: Collection<PacketType>
    val wrapperType: KClass<out UmpaPacketContainer>
}
