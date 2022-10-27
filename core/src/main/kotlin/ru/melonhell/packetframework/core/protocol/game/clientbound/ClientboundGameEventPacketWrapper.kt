package ru.melonhell.packetframework.core.protocol.game.clientbound

import ru.melonhell.packetframework.core.PacketWrapper

data class ClientboundGameEventPacketWrapper(
    var gameEvent: GameEvent,
    var value: Float
) : PacketWrapper {
    override fun clone(): PacketWrapper {
        return this.copy()
    }

    enum class GameEvent {
        NO_RESPAWN_BLOCK_AVAILABLE,
        START_RAINING,
        STOP_RAINING,
        CHANGE_GAME_MODE,
        WIN_GAME,
        DEMO_EVENT,
        ARROW_HIT_PLAYER,
        RAIN_LEVEL_CHANGE,
        THUNDER_LEVEL_CHANGE,
        PUFFER_FISH_STING,
        GUARDIAN_ELDER_EFFECT,
        IMMEDIATE_RESPAWN
    }
}