package ru.melonhell.umpa.bukkit.packet.protocollib.converter.serverbound.setCreativeSlot

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import org.bukkit.inventory.ItemStack
import ru.melonhell.umpa.bukkit.exceptions.UmpaWrongConverterException
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.PacketConverter
import ru.melonhell.umpa.bukkit.utils.converter.BukkitConverter.bukkit
import ru.melonhell.umpa.bukkit.utils.converter.BukkitConverter.umpa
import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.packet.containers.serverbound.UmpaSbSetCreativeSlotPacket

@MinMaxMinecraftVersion("1.8", "latest")
class SbSetCreativeSlotPacketConverter_v1_8_0 : PacketConverter {
    override fun wrap(container: PacketContainer): UmpaSbSetCreativeSlotPacket {
        val slot: Int = container.integers.read(0)
        val item: ItemStack = container.itemModifier.read(0)
        return UmpaSbSetCreativeSlotPacket(slot, item.umpa())
    }

    override fun unwrap(wrapper: UmpaPacket): List<PacketContainer> {
        if (wrapper !is UmpaSbSetCreativeSlotPacket) throw UmpaWrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Client.SET_CREATIVE_SLOT)
        container.integers.write(0, wrapper.slot)
        container.itemModifier.write(0, wrapper.item.bukkit())
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Client.SET_CREATIVE_SLOT)
    override val packetType = UmpaPacketType.SB_SET_CREATIVE_SLOT
}