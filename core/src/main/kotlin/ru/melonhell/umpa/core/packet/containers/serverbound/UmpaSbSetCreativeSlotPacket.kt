package ru.melonhell.umpa.core.packet.containers.serverbound

import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.utils.UmpaLook
import ru.melonhell.umpa.core.utils.UmpaVector
import ru.melonhell.umpa.core.wrappers.UmpaItemStack
import java.util.*

data class UmpaSbSetCreativeSlotPacket(
    var slot: Int,
    var item: UmpaItemStack
) : UmpaPacket(UmpaPacketType.SB_SET_CREATIVE_SLOT) {
    override fun clone(): UmpaPacket {
        return this.copy()
    }
}
