package ru.melonhell.umpa.core.protocol.game.clientbound

import ru.melonhell.umpa.core.enums.EquipmentSlot
import ru.melonhell.umpa.core.wrappers.ItemStackWrapper

data class CbSetEquipmentPacketWrapper(
    var entityId: Int,
    var equipment: List<Pair<EquipmentSlot, ItemStackWrapper>>
) : ru.melonhell.umpa.core.PacketWrapper {
    override fun clone(): ru.melonhell.umpa.core.PacketWrapper {
        return this.copy()
    }
}
