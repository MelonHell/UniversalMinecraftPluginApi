package ru.melonhell.umpa.bukkit.utils

import com.comphenix.protocol.utility.MinecraftReflection
import com.comphenix.protocol.wrappers.*
import com.comphenix.protocol.wrappers.EnumWrappers.EntityPose
import com.comphenix.protocol.wrappers.WrappedDataWatcher.WrappedDataWatcherObject
import net.kyori.adventure.platform.bukkit.MinecraftComponentSerializer
import net.kyori.adventure.text.Component
import org.bukkit.entity.Pose
import org.bukkit.util.EulerAngle
import java.util.*

object ProtocolLibUtils {
    fun wrapMetaObject(index: Int, value: Any): WrappedWatchableObject {
        return wrapMetaObject(index, value, false, value.javaClass)
    }

    fun wrapMetaOptional(index: Int, value: Any?, valueClass: Class<*>): WrappedWatchableObject {
        return wrapMetaObject(index, value, true, valueClass)
    }

    @Suppress("UnstableApiUsage")
    private fun wrapMetaObject(
        index: Int,
        value1: Any?,
        isOptional: Boolean,
        valueClass: Class<*>
    ): WrappedWatchableObject {
        var value = value1
        if (Component::class.java == valueClass) {
            if (value != null) value = MinecraftComponentSerializer.get().serialize((value as Component))
            return wrapMetaObject(index, value, isOptional, MinecraftReflection.getIChatBaseComponentClass())
        }
        if (String::class.java == valueClass) {
            if (value != null) value = WrappedChatComponent.fromText(value as String).handle
            return wrapMetaObject(index, value, isOptional, MinecraftReflection.getIChatBaseComponentClass())
        }
        if (EulerAngle::class.java == valueClass) {
            if (value != null) {
                val eulerAngle = value as EulerAngle
                val vector3F = Vector3F(
                    Math.toDegrees(eulerAngle.x).toFloat(),
                    Math.toDegrees(eulerAngle.y).toFloat(),
                    Math.toDegrees(eulerAngle.z).toFloat()
                )
                value = Vector3F.getConverter().getGeneric(vector3F)
            }
            return wrapMetaObject(index, value, isOptional, Vector3F.getMinecraftClass())
        }
        if (BlockPosition::class.java == valueClass) {
            if (value != null) value = BlockPosition.getConverter().getGeneric(value as BlockPosition?)
            return wrapMetaObject(index, value, isOptional, MinecraftReflection.getBlockPositionClass())
        }
        if (Pose::class.java == valueClass) {
            if (value != null) {
                val pose = value as Pose
                val entityPose = EntityPose.values()[pose.ordinal]
                value = entityPose.toNms()
            }
            return wrapMetaObject(index, value, isOptional, EnumWrappers.getEntityPoseClass())
        }
        val registry = WrappedDataWatcher.Registry.get(valueClass, isOptional)
        val wrappedDataWatcherObject = WrappedDataWatcherObject(index, registry)
        return if (isOptional) WrappedWatchableObject(
            wrappedDataWatcherObject,
            Optional.ofNullable(value)
        ) else WrappedWatchableObject(wrappedDataWatcherObject, value)
    }

    fun getSharedFlag(byte: Byte, index: Int): Boolean {
        return byte.toInt() and (1 shl index) != 0
    }

    fun setSharedFlag(byte: Byte, index: Int, value: Boolean): Byte {
        return if (value) {
            (byte.toInt() or (1 shl index)).toByte()
        } else {
            (byte.toInt() and (1 shl index).inv()).toByte()
        }
    }
}