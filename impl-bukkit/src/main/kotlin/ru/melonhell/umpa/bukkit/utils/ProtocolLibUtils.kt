package ru.melonhell.umpa.bukkit.utils

import com.comphenix.protocol.utility.MinecraftReflection
import com.comphenix.protocol.wrappers.*
import com.comphenix.protocol.wrappers.EnumWrappers.EntityPose
import com.comphenix.protocol.wrappers.WrappedDataWatcher.WrappedDataWatcherObject
import net.kyori.adventure.platform.bukkit.MinecraftComponentSerializer
import net.kyori.adventure.text.Component
import org.bukkit.entity.Pose
import org.bukkit.util.EulerAngle
import ru.melonhell.umpa.core.enums.UmpaEntityPose
import ru.melonhell.umpa.core.utils.UmpaBlockPos
import ru.melonhell.umpa.core.utils.UmpaEulerAngle
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
        originalValue: Any?,
        isOptional: Boolean,
        valueClass: Class<*>
    ): WrappedWatchableObject {
        var value = originalValue
        return when (valueClass) {
            Component::class.java -> {
                if (value != null) value = MinecraftComponentSerializer.get().serialize((value as Component))
                wrapMetaObject(index, value, isOptional, MinecraftReflection.getIChatBaseComponentClass())
            }

            String::class.java -> {
                if (value != null) value = WrappedChatComponent.fromText(value as String).handle
                wrapMetaObject(index, value, isOptional, MinecraftReflection.getIChatBaseComponentClass())
            }

            EulerAngle::class.java -> {
                if (value != null) {
                    value as EulerAngle
                    val vector3F = Vector3F(
                        Math.toDegrees(value.x).toFloat(),
                        Math.toDegrees(value.y).toFloat(),
                        Math.toDegrees(value.z).toFloat()
                    )
                    value = Vector3F.getConverter().getGeneric(vector3F)
                }
                wrapMetaObject(index, value, isOptional, Vector3F.getMinecraftClass())
            }

            UmpaEulerAngle::class.java -> {
                if (value != null) {
                    value as UmpaEulerAngle
                    value = Vector3F.getConverter().getGeneric(Vector3F(value.x, value.y, value.z))
                }
                wrapMetaObject(index, value, isOptional, Vector3F.getMinecraftClass())
            }

            BlockPosition::class.java -> {
                if (value != null) value = BlockPosition.getConverter().getGeneric(value as BlockPosition?)
                wrapMetaObject(index, value, isOptional, MinecraftReflection.getBlockPositionClass())
            }

            UmpaBlockPos::class.java -> {
                if (value != null) {
                    value as UmpaBlockPos
                    value = BlockPosition.getConverter().getGeneric(BlockPosition(value.x, value.y, value.z))
                }
                wrapMetaObject(index, value, isOptional, MinecraftReflection.getBlockPositionClass())
            }

            Pose::class.java -> {
                if (value != null) {
                    val pose = value as Pose
                    value = EntityPose.values()[pose.ordinal].toNms()
                }
                wrapMetaObject(index, value, isOptional, EnumWrappers.getEntityPoseClass())
            }

            UmpaEntityPose::class.java -> {
                if (value != null) {
                    value as UmpaEntityPose
                    value = EntityPose.values()[value.ordinal].toNms()
                }
                wrapMetaObject(index, value, isOptional, EnumWrappers.getEntityPoseClass())
            }

            else -> {
                val registry = WrappedDataWatcher.Registry.get(valueClass, isOptional)
                val wrappedDataWatcherObject = WrappedDataWatcherObject(index, registry)
                if (isOptional) WrappedWatchableObject(wrappedDataWatcherObject, Optional.ofNullable(value))
                else WrappedWatchableObject(wrappedDataWatcherObject, value)
            }
        }
    }
}