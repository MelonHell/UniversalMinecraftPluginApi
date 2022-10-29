package ru.melonhell.umpa.bukkit.converter

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import kotlin.reflect.KClass

interface PacketConverter {
    fun wrap(container: PacketContainer): ru.melonhell.umpa.core.PacketWrapper
    fun unwrap(wrapper: ru.melonhell.umpa.core.PacketWrapper): List<PacketContainer>
    val protocolLibTypes: Collection<PacketType>
    val wrapperType: KClass<out ru.melonhell.umpa.core.PacketWrapper>
}
