package ru.melonhell.packetframework.core.protocol.game.clientbound

import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.wrappers.ItemStackWrapper

data class ClientboundSetEquipmentPacketWrapper(
    var entityId: Int,
    var equipment: List<Pair<EquipmentSlot, ItemStackWrapper>>
) : PacketWrapper {
    override fun clone(): PacketWrapper {
        return this.copy()
    }

    enum class EquipmentSlot {
        HAND,
        OFF_HAND,
        FEET,
        LEGS,
        CHEST,
        HEAD
    }
}
