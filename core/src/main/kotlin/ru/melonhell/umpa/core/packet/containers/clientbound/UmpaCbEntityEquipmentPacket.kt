package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.enums.UmpaEquipmentSlot
import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.wrappers.UmpaItemStack

data class UmpaCbEntityEquipmentPacket(
    var entityId: Int,
    var equipment: List<Pair<UmpaEquipmentSlot, UmpaItemStack>>
) : UmpaPacket(UmpaPacketType.CB_ENTITY_EQUIPMENT) {
    override fun clone(): UmpaPacket {
        return this.copy()
    }
}
