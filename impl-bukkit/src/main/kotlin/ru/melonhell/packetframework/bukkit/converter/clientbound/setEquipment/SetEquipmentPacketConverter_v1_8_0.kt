package ru.melonhell.packetframework.bukkit.converter.clientbound.setEquipment

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import com.comphenix.protocol.wrappers.EnumWrappers
import ru.melonhell.packetframework.bukkit.converter.PacketConverter
import ru.melonhell.packetframework.bukkit.converter.ProtocolVersion
import ru.melonhell.packetframework.bukkit.exceptions.WrongConverterException
import ru.melonhell.packetframework.bukkit.wrappers.BukkitItemStackWrapper
import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.enums.EquipmentSlot
import ru.melonhell.packetframework.core.protocol.game.clientbound.CbSetEquipmentPacketWrapper

@ProtocolVersion("1.8", "latest", CbSetEquipmentPacketWrapper::class)
class SetEquipmentPacketConverter_v1_8_0 : PacketConverter {

    private val equipmentSlots = EquipmentSlot.values()
    private val itemSlots = EnumWrappers.ItemSlot.values()

    override fun wrap(container: PacketContainer): CbSetEquipmentPacketWrapper {
        val entityId = container.integers.read(0)
        val pairList = container.slotStackPairLists.read(0)
        val equipment = pairList.map {
            val slot = equipmentSlots[it.first.ordinal]
            Pair(slot, BukkitItemStackWrapper(it.second))
        }
        return CbSetEquipmentPacketWrapper(entityId, equipment)
    }

    override fun unwrap(wrapper: PacketWrapper): List<PacketContainer> {
        if (wrapper !is CbSetEquipmentPacketWrapper) throw WrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.ENTITY_EQUIPMENT)
        container.integers.write(0, wrapper.entityId)
        val pairList = wrapper.equipment.map {
            val slot = itemSlots[it.first.ordinal]
            com.comphenix.protocol.wrappers.Pair(slot, (it.second as BukkitItemStackWrapper).itemStack)
        }
        container.slotStackPairLists.write(0, pairList)
        return listOf(container)
    }

    override fun getWrapTypes() = listOf(PacketType.Play.Server.ENTITY_EQUIPMENT)
}