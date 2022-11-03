package ru.melonhell.umpa.bukkit.packet.protocollib.converter.clientbound.entityEquipment

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import org.bukkit.inventory.ItemStack
import ru.melonhell.umpa.bukkit.exceptions.UmpaWrongConverterException
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.PacketConverter
import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.bukkit.utils.converter.BukkitConverter.umpa
import ru.melonhell.umpa.bukkit.utils.converter.ProtocolLibEnumConverter.protocolLib
import ru.melonhell.umpa.bukkit.utils.converter.ProtocolLibEnumConverter.umpa
import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.packet.containers.clientbound.UmpaCbEntityEquipmentPacket
import java.util.stream.Collectors

@MinMaxMinecraftVersion("1.8", "latest")
class CbEntityEquipmentPacketConverter_v1_8_0 : PacketConverter {
    override fun wrap(container: PacketContainer): UmpaCbEntityEquipmentPacket {
        val entityId = container.integers.read(0)
        val pairList = container.slotStackPairLists.read(0)
        val collect = pairList.stream().collect(Collectors.toMap({ it.first.umpa() }, { it.second.umpa() }))
        return UmpaCbEntityEquipmentPacket(entityId, collect)
    }

    override fun unwrap(wrapper: UmpaPacket): List<PacketContainer> {
        if (wrapper !is UmpaCbEntityEquipmentPacket) throw UmpaWrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.ENTITY_EQUIPMENT)
        container.integers.write(0, wrapper.entityId)
        val pairList = wrapper.equipment.map {
            val slot = it.key.protocolLib()
            com.comphenix.protocol.wrappers.Pair(slot, it.value?.handle as ItemStack)
        }
        container.slotStackPairLists.write(0, pairList)
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Server.ENTITY_EQUIPMENT)
    override val packetType = UmpaPacketType.CB_ENTITY_EQUIPMENT
}