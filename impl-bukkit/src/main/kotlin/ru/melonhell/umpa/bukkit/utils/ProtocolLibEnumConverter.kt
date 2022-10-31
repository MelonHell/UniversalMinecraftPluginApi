package ru.melonhell.umpa.bukkit.utils

import com.comphenix.protocol.wrappers.EnumWrappers
import ru.melonhell.umpa.core.enums.UmpaEquipmentSlot
import ru.melonhell.umpa.core.packet.containers.serverbound.UmpaSbPlayerActionPacket

object ProtocolLibEnumConverter {
    fun toProtocolLib(umpaEquipmentSlot: UmpaEquipmentSlot): EnumWrappers.ItemSlot {
        return when (umpaEquipmentSlot) {
            UmpaEquipmentSlot.HAND -> EnumWrappers.ItemSlot.MAINHAND
            UmpaEquipmentSlot.OFF_HAND -> EnumWrappers.ItemSlot.OFFHAND
            UmpaEquipmentSlot.FEET -> EnumWrappers.ItemSlot.FEET
            UmpaEquipmentSlot.LEGS -> EnumWrappers.ItemSlot.LEGS
            UmpaEquipmentSlot.CHEST -> EnumWrappers.ItemSlot.CHEST
            UmpaEquipmentSlot.HEAD -> EnumWrappers.ItemSlot.HEAD
        }
    }

    fun fromProtocolLib(itemSlot: EnumWrappers.ItemSlot): UmpaEquipmentSlot {
        return when (itemSlot) {
            EnumWrappers.ItemSlot.MAINHAND -> UmpaEquipmentSlot.HAND
            EnumWrappers.ItemSlot.OFFHAND -> UmpaEquipmentSlot.OFF_HAND
            EnumWrappers.ItemSlot.FEET -> UmpaEquipmentSlot.FEET
            EnumWrappers.ItemSlot.LEGS -> UmpaEquipmentSlot.LEGS
            EnumWrappers.ItemSlot.CHEST -> UmpaEquipmentSlot.CHEST
            EnumWrappers.ItemSlot.HEAD -> UmpaEquipmentSlot.HEAD
        }
    }

    fun toProtocolLib(playerAction: UmpaSbPlayerActionPacket.PlayerAction): EnumWrappers.PlayerAction {
        return when (playerAction) {
            UmpaSbPlayerActionPacket.PlayerAction.PRESS_SHIFT_KEY -> EnumWrappers.PlayerAction.START_SNEAKING
            UmpaSbPlayerActionPacket.PlayerAction.RELEASE_SHIFT_KEY -> EnumWrappers.PlayerAction.STOP_SNEAKING
            UmpaSbPlayerActionPacket.PlayerAction.STOP_SLEEPING -> EnumWrappers.PlayerAction.STOP_SLEEPING
            UmpaSbPlayerActionPacket.PlayerAction.START_SPRINTING -> EnumWrappers.PlayerAction.START_SPRINTING
            UmpaSbPlayerActionPacket.PlayerAction.STOP_SPRINTING -> EnumWrappers.PlayerAction.STOP_SPRINTING
            UmpaSbPlayerActionPacket.PlayerAction.START_RIDING_JUMP -> EnumWrappers.PlayerAction.START_RIDING_JUMP
            UmpaSbPlayerActionPacket.PlayerAction.STOP_RIDING_JUMP -> EnumWrappers.PlayerAction.STOP_RIDING_JUMP
            UmpaSbPlayerActionPacket.PlayerAction.OPEN_HORSE_INVENTORY -> EnumWrappers.PlayerAction.OPEN_INVENTORY
            UmpaSbPlayerActionPacket.PlayerAction.START_FALL_FLYING -> EnumWrappers.PlayerAction.START_FALL_FLYING
        }
    }

    fun fromProtocolLib(playerAction: EnumWrappers.PlayerAction): UmpaSbPlayerActionPacket.PlayerAction {
        return when (playerAction) {
            EnumWrappers.PlayerAction.START_SNEAKING -> UmpaSbPlayerActionPacket.PlayerAction.PRESS_SHIFT_KEY
            EnumWrappers.PlayerAction.STOP_SNEAKING -> UmpaSbPlayerActionPacket.PlayerAction.RELEASE_SHIFT_KEY
            EnumWrappers.PlayerAction.STOP_SLEEPING -> UmpaSbPlayerActionPacket.PlayerAction.STOP_SLEEPING
            EnumWrappers.PlayerAction.START_SPRINTING -> UmpaSbPlayerActionPacket.PlayerAction.START_SPRINTING
            EnumWrappers.PlayerAction.STOP_SPRINTING -> UmpaSbPlayerActionPacket.PlayerAction.STOP_SPRINTING
            EnumWrappers.PlayerAction.START_RIDING_JUMP -> UmpaSbPlayerActionPacket.PlayerAction.START_RIDING_JUMP
            EnumWrappers.PlayerAction.STOP_RIDING_JUMP -> UmpaSbPlayerActionPacket.PlayerAction.STOP_RIDING_JUMP
            EnumWrappers.PlayerAction.OPEN_INVENTORY -> UmpaSbPlayerActionPacket.PlayerAction.OPEN_HORSE_INVENTORY
            EnumWrappers.PlayerAction.START_FALL_FLYING -> UmpaSbPlayerActionPacket.PlayerAction.START_FALL_FLYING
        }
    }
}