package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.enums.EquipmentSlot
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.wrappers.UmpaItemStack

data class UmpaCbEntityEquipmentPacket(
    var entityId: Int,
    var equipment: List<Pair<EquipmentSlot, UmpaItemStack>>
) : UmpaPacket {
    override fun clone(): UmpaPacket {
        return this.copy()
    }
}
