package ru.melonhell.umpa.bukkit.converter.clientbound.setEquipment

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import com.comphenix.protocol.wrappers.EnumWrappers
import ru.melonhell.umpa.bukkit.converter.PacketConverter
import ru.melonhell.umpa.bukkit.converter.ProtocolVersion
import ru.melonhell.umpa.bukkit.exceptions.WrongConverterException
import ru.melonhell.umpa.bukkit.wrappers.BukkitUmpaItemStack
import ru.melonhell.umpa.core.enums.EquipmentSlot
import ru.melonhell.umpa.core.packet.containers.UmpaPacketContainer
import ru.melonhell.umpa.core.packet.containers.clientbound.UmpaCbEntityEquipmentPacket

@ProtocolVersion("1.8", "latest")
class SetEquipmentPacketConverter_v1_8_0 : PacketConverter {

    private val equipmentSlots = EquipmentSlot.values()
    private val itemSlots = EnumWrappers.ItemSlot.values()

    override fun wrap(container: PacketContainer): UmpaCbEntityEquipmentPacket {
        val entityId = container.integers.read(0)
        val pairList = container.slotStackPairLists.read(0)
        val equipment = pairList.map {
            val slot = equipmentSlots[it.first.ordinal]
            Pair(slot, BukkitUmpaItemStack(it.second))
        }
        return UmpaCbEntityEquipmentPacket(entityId, equipment)
    }

    override fun unwrap(wrapper: UmpaPacketContainer): List<PacketContainer> {
        if (wrapper !is UmpaCbEntityEquipmentPacket) throw WrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.ENTITY_EQUIPMENT)
        container.integers.write(0, wrapper.entityId)
        val pairList = wrapper.equipment.map {
            val slot = itemSlots[it.first.ordinal]
            com.comphenix.protocol.wrappers.Pair(slot, (it.second as BukkitUmpaItemStack).itemStack)
        }
        container.slotStackPairLists.write(0, pairList)
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Server.ENTITY_EQUIPMENT)
    override val wrapperType = UmpaCbEntityEquipmentPacket::class
}