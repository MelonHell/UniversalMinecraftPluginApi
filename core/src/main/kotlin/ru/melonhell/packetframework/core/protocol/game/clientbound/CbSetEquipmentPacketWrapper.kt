package ru.melonhell.packetframework.core.protocol.game.clientbound

import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.enums.EquipmentSlot
import ru.melonhell.packetframework.core.wrappers.ItemStackWrapper

data class CbSetEquipmentPacketWrapper(
    var entityId: Int,
    var equipment: List<Pair<EquipmentSlot, ItemStackWrapper>>
) : PacketWrapper {
    override fun clone(): PacketWrapper {
        return this.copy()
    }
}
