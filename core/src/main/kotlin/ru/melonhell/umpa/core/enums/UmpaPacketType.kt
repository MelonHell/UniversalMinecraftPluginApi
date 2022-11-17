package ru.melonhell.umpa.core.enums

import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.packet.containers.clientbound.*
import ru.melonhell.umpa.core.packet.containers.serverbound.*
import kotlin.reflect.KClass

enum class UmpaPacketType(private val packetClass: KClass<out UmpaPacket>, val direction: Direction) {
    // CLIENTBOUND
    CB_ENTITY_ANIMATE(UmpaCbEntityAnimatePacket::class, Direction.CLIENTBOUND),
    CB_ENTITY_EQUIPMENT(UmpaCbEntityEquipmentPacket::class, Direction.CLIENTBOUND),
    CB_ENTITY_HEAD_ROTATION(UmpaCbEntityHeadRotationPacket::class, Direction.CLIENTBOUND),
    CB_ENTITY_METADATA(UmpaCbEntityMetadataPacket::class, Direction.CLIENTBOUND),
    CB_ENTITY_PASSENGERS(UmpaCbEntityPassengersPacket::class, Direction.CLIENTBOUND),
    CB_ENTITY_REMOVE(UmpaCbEntityRemovePacket::class, Direction.CLIENTBOUND),
    CB_ENTITY_SPAWN(UmpaCbEntitySpawnPacket::class, Direction.CLIENTBOUND),
    CB_ENTITY_TELEPORT(UmpaCbEntityTeleportPacket::class, Direction.CLIENTBOUND),
    CB_ENTITY_VELOCITY(UmpaCbEntityVelocityPacket::class, Direction.CLIENTBOUND),
    CB_GAME_EVENT(UmpaCbGameEventPacket::class, Direction.CLIENTBOUND),
    CB_PLAYER_ABILITIES(UmpaCbPlayerAbilitiesPacket::class, Direction.CLIENTBOUND),
    CB_PLAYER_COMBAT_KILL(UmpaCbPlayerCombatKillPacket::class, Direction.CLIENTBOUND),
    CB_SET_CAMERA(UmpaCbSetCameraPacket::class, Direction.CLIENTBOUND),
    CB_SET_HEALTH(UmpaCbSetHealthPacket::class, Direction.CLIENTBOUND),
    CB_WORLD_BORDER(UmpaCbWorldBorderPacket::class, Direction.CLIENTBOUND),
    CB_WORLD_EVENT(UmpaCbWorldEventPacket::class, Direction.CLIENTBOUND),

    // SERVERBOUND
    SB_INTERACT_ENTITY(UmpaSbInteractEntityPacket::class, Direction.SERVERBOUND),
    SB_PLAYER_ACTION(UmpaSbPlayerActionPacket::class, Direction.SERVERBOUND),
    SB_PLAYER_MOVE(UmpaSbPlayerMovePacket::class, Direction.SERVERBOUND),
    SB_SET_CREATIVE_SLOT(UmpaSbSetCreativeSlotPacket::class, Direction.SERVERBOUND),
    SB_VEHICLE_INPUT(UmpaSbVehicleInputPacket::class, Direction.SERVERBOUND);

    enum class Direction {
        CLIENTBOUND,
        SERVERBOUND
    }

    val javaClass get() = packetClass.java
}