package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket

data class UmpaCbGameEventPacket @JvmOverloads constructor(
    var gameEvent: GameEvent,
    var value: Float = 0f
) : UmpaPacket(UmpaPacketType.CB_GAME_EVENT) {
    override fun clone(): UmpaPacket {
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