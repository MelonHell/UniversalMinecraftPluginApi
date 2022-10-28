package ru.melonhell.packetframework.bukkit.converter

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.packetframework.core.PacketWrapper
import kotlin.reflect.KClass

interface PacketConverter {
    fun wrap(container: PacketContainer): PacketWrapper
    fun unwrap(wrapper: PacketWrapper): List<PacketContainer>
    val protocolLibTypes: Collection<PacketType>
    val wrapperType: KClass<out PacketWrapper>
}
