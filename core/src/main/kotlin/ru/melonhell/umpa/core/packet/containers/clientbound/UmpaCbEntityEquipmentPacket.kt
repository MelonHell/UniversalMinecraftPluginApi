package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.enums.EquipmentSlot
import ru.melonhell.umpa.core.packet.containers.UmpaPacketContainer
import ru.melonhell.umpa.core.wrappers.UmpaItemStack

data class UmpaCbEntityEquipmentPacket(
    var entityId: Int,
    var equipment: List<Pair<EquipmentSlot, UmpaItemStack>>
) : UmpaPacketContainer {
    override fun clone(): UmpaPacketContainer {
        return this.copy()
    }
}
