package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.packet.containers.UmpaPacket

data class UmpaCbEntityRemovePacket(
    var entityIds: List<Int>
) : UmpaPacket {
    override fun clone(): UmpaPacket {
        return this.copy()
    }
}
