package ru.melonhell.packetframework.bukkit.converter

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.packetframework.core.PacketWrapper

interface PacketConverter {
    fun wrap(container: PacketContainer): PacketWrapper
    fun unwrap(wrapper: PacketWrapper): List<PacketContainer>
    fun getWrapTypes(): Collection<PacketType>
}
