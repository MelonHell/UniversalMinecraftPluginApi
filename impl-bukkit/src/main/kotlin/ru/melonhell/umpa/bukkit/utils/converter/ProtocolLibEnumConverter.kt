package ru.melonhell.umpa.bukkit.utils.converter

import com.comphenix.protocol.wrappers.EnumWrappers
import ru.melonhell.umpa.core.enums.UmpaEntityPose
import ru.melonhell.umpa.core.enums.UmpaEquipmentSlot
import ru.melonhell.umpa.core.packet.containers.serverbound.UmpaSbPlayerActionPacket

object ProtocolLibEnumConverter {
    @JvmStatic
    fun UmpaEquipmentSlot.protocolLib(): EnumWrappers.ItemSlot {
        return when (this) {
            UmpaEquipmentSlot.HAND -> EnumWrappers.ItemSlot.MAINHAND
            UmpaEquipmentSlot.OFF_HAND -> EnumWrappers.ItemSlot.OFFHAND
            UmpaEquipmentSlot.FEET -> EnumWrappers.ItemSlot.FEET
            UmpaEquipmentSlot.LEGS -> EnumWrappers.ItemSlot.LEGS
            UmpaEquipmentSlot.CHEST -> EnumWrappers.ItemSlot.CHEST
            UmpaEquipmentSlot.HEAD -> EnumWrappers.ItemSlot.HEAD
        }
    }

    @JvmStatic
    fun EnumWrappers.ItemSlot.umpa(): UmpaEquipmentSlot {
        return when (this) {
            EnumWrappers.ItemSlot.MAINHAND -> UmpaEquipmentSlot.HAND
            EnumWrappers.ItemSlot.OFFHAND -> UmpaEquipmentSlot.OFF_HAND
            EnumWrappers.ItemSlot.FEET -> UmpaEquipmentSlot.FEET
            EnumWrappers.ItemSlot.LEGS -> UmpaEquipmentSlot.LEGS
            EnumWrappers.ItemSlot.CHEST -> UmpaEquipmentSlot.CHEST
            EnumWrappers.ItemSlot.HEAD -> UmpaEquipmentSlot.HEAD
        }
    }

    @JvmStatic
    fun UmpaSbPlayerActionPacket.Action.protocolLib(): EnumWrappers.PlayerAction {
        return when (this) {
            UmpaSbPlayerActionPacket.Action.PRESS_SHIFT_KEY -> EnumWrappers.PlayerAction.START_SNEAKING
            UmpaSbPlayerActionPacket.Action.RELEASE_SHIFT_KEY -> EnumWrappers.PlayerAction.STOP_SNEAKING
            UmpaSbPlayerActionPacket.Action.STOP_SLEEPING -> EnumWrappers.PlayerAction.STOP_SLEEPING
            UmpaSbPlayerActionPacket.Action.START_SPRINTING -> EnumWrappers.PlayerAction.START_SPRINTING
            UmpaSbPlayerActionPacket.Action.STOP_SPRINTING -> EnumWrappers.PlayerAction.STOP_SPRINTING
            UmpaSbPlayerActionPacket.Action.START_RIDING_JUMP -> EnumWrappers.PlayerAction.START_RIDING_JUMP
            UmpaSbPlayerActionPacket.Action.STOP_RIDING_JUMP -> EnumWrappers.PlayerAction.STOP_RIDING_JUMP
            UmpaSbPlayerActionPacket.Action.OPEN_HORSE_INVENTORY -> EnumWrappers.PlayerAction.OPEN_INVENTORY
            UmpaSbPlayerActionPacket.Action.START_FALL_FLYING -> EnumWrappers.PlayerAction.START_FALL_FLYING
        }
    }

    @JvmStatic
    fun EnumWrappers.PlayerAction.umpa(): UmpaSbPlayerActionPacket.Action {
        return when (this) {
            EnumWrappers.PlayerAction.START_SNEAKING -> UmpaSbPlayerActionPacket.Action.PRESS_SHIFT_KEY
            EnumWrappers.PlayerAction.STOP_SNEAKING -> UmpaSbPlayerActionPacket.Action.RELEASE_SHIFT_KEY
            EnumWrappers.PlayerAction.STOP_SLEEPING -> UmpaSbPlayerActionPacket.Action.STOP_SLEEPING
            EnumWrappers.PlayerAction.START_SPRINTING -> UmpaSbPlayerActionPacket.Action.START_SPRINTING
            EnumWrappers.PlayerAction.STOP_SPRINTING -> UmpaSbPlayerActionPacket.Action.STOP_SPRINTING
            EnumWrappers.PlayerAction.START_RIDING_JUMP -> UmpaSbPlayerActionPacket.Action.START_RIDING_JUMP
            EnumWrappers.PlayerAction.STOP_RIDING_JUMP -> UmpaSbPlayerActionPacket.Action.STOP_RIDING_JUMP
            EnumWrappers.PlayerAction.OPEN_INVENTORY -> UmpaSbPlayerActionPacket.Action.OPEN_HORSE_INVENTORY
            EnumWrappers.PlayerAction.START_FALL_FLYING -> UmpaSbPlayerActionPacket.Action.START_FALL_FLYING
        }
    }

    @JvmStatic
    fun UmpaEntityPose.protocolLib(): EnumWrappers.EntityPose {
        return when (this) {
            UmpaEntityPose.STANDING -> EnumWrappers.EntityPose.STANDING
            UmpaEntityPose.FALL_FLYING -> EnumWrappers.EntityPose.FALL_FLYING
            UmpaEntityPose.SLEEPING -> EnumWrappers.EntityPose.SLEEPING
            UmpaEntityPose.SWIMMING -> EnumWrappers.EntityPose.SWIMMING
            UmpaEntityPose.SPIN_ATTACK -> EnumWrappers.EntityPose.SPIN_ATTACK
            UmpaEntityPose.SNEAKING -> EnumWrappers.EntityPose.CROUCHING
            UmpaEntityPose.LONG_JUMPING -> EnumWrappers.EntityPose.LONG_JUMPING
            UmpaEntityPose.DYING -> EnumWrappers.EntityPose.DYING
            UmpaEntityPose.CROAKING -> EnumWrappers.EntityPose.CROAKING
            UmpaEntityPose.USING_TONGUE -> EnumWrappers.EntityPose.USING_TONGUE
            UmpaEntityPose.ROARING -> EnumWrappers.EntityPose.ROARING
            UmpaEntityPose.SNIFFING -> EnumWrappers.EntityPose.SNIFFING
            UmpaEntityPose.EMERGING -> EnumWrappers.EntityPose.EMERGING
            UmpaEntityPose.DIGGING -> EnumWrappers.EntityPose.DIGGING
        }
    }

    @JvmStatic
    fun EnumWrappers.EntityPose.umpa(): UmpaEntityPose {
        return when (this) {
            EnumWrappers.EntityPose.STANDING -> UmpaEntityPose.STANDING
            EnumWrappers.EntityPose.FALL_FLYING -> UmpaEntityPose.FALL_FLYING
            EnumWrappers.EntityPose.SLEEPING -> UmpaEntityPose.SLEEPING
            EnumWrappers.EntityPose.SWIMMING -> UmpaEntityPose.SWIMMING
            EnumWrappers.EntityPose.SPIN_ATTACK -> UmpaEntityPose.SPIN_ATTACK
            EnumWrappers.EntityPose.CROUCHING -> UmpaEntityPose.SNEAKING
            EnumWrappers.EntityPose.LONG_JUMPING -> UmpaEntityPose.LONG_JUMPING
            EnumWrappers.EntityPose.DYING -> UmpaEntityPose.DYING
            EnumWrappers.EntityPose.CROAKING -> UmpaEntityPose.CROAKING
            EnumWrappers.EntityPose.USING_TONGUE -> UmpaEntityPose.USING_TONGUE
            EnumWrappers.EntityPose.ROARING -> UmpaEntityPose.ROARING
            EnumWrappers.EntityPose.SNIFFING -> UmpaEntityPose.SNIFFING
            EnumWrappers.EntityPose.EMERGING -> UmpaEntityPose.EMERGING
            EnumWrappers.EntityPose.DIGGING -> UmpaEntityPose.DIGGING
        }
    }
}