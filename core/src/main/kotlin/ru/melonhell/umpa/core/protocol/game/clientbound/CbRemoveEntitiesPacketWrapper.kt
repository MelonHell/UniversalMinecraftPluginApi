package ru.melonhell.umpa.core.protocol.game.clientbound

data class CbRemoveEntitiesPacketWrapper(
    var entityIds: List<Int>
) : ru.melonhell.umpa.core.PacketWrapper {
    override fun clone(): ru.melonhell.umpa.core.PacketWrapper {
        return this.copy()
    }
}
