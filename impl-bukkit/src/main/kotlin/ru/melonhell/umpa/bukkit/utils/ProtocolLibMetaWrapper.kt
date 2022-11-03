package ru.melonhell.umpa.bukkit.utils

import com.comphenix.protocol.utility.MinecraftReflection
import com.comphenix.protocol.wrappers.*
import com.comphenix.protocol.wrappers.WrappedDataWatcher.WrappedDataWatcherObject
import net.kyori.adventure.text.Component
import org.bukkit.inventory.ItemStack
import ru.melonhell.umpa.bukkit.utils.converter.BukkitConverter.umpa
import ru.melonhell.umpa.bukkit.utils.converter.ProtocolLibConverter.kyori
import ru.melonhell.umpa.bukkit.utils.converter.ProtocolLibConverter.nms
import ru.melonhell.umpa.bukkit.utils.converter.ProtocolLibConverter.umpa
import ru.melonhell.umpa.bukkit.utils.converter.ProtocolLibConverter.umpaEulerAngle
import ru.melonhell.umpa.bukkit.utils.converter.ProtocolLibEnumConverter.nms
import ru.melonhell.umpa.bukkit.utils.converter.ProtocolLibEnumConverter.umpa
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaCatMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaFrogMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaPaintingMetadata
import ru.melonhell.umpa.core.enums.UmpaEntityPose
import ru.melonhell.umpa.core.utils.UmpaBlockPos
import ru.melonhell.umpa.core.utils.UmpaDirection
import ru.melonhell.umpa.core.utils.UmpaEulerAngle
import ru.melonhell.umpa.core.wrappers.UmpaItemStack
import java.util.*

object ProtocolLibMetaWrapper {
    private val catVariantClass = MinecraftReflection.getMinecraftClass("world.entity.animal.CatVariant")
    private val catVariantRegistry = WrappedRegistry.getRegistry(catVariantClass)
    private val frogVariantClass = MinecraftReflection.getMinecraftClass("world.entity.animal.FrogVariant")
    private val frogVariantRegistry = WrappedRegistry.getRegistry(frogVariantClass)
    private val paintingVariantClass = MinecraftReflection.getMinecraftClass("world.entity.decoration.PaintingVariant")
    private val paintingVariantRegistry = WrappedRegistry.getRegistry(paintingVariantClass)

    fun wrap(index: Int, value: Any): WrappedWatchableObject {
        return wrap(index, value, false, value.javaClass)
    }

    fun <T> wrapOptional(index: Int, value: Optional<T>, clazz: Class<T>): WrappedWatchableObject {
        return wrap(index, value.orElse(null), true, clazz)
    }

    fun <T> unwrap(wrappedWatchableObject: WrappedWatchableObject, clazz: Class<T>): T {
        return unwrapValue(wrappedWatchableObject.value, clazz)
    }

    fun <T> unwrapOptional(
        wrappedWatchableObject: WrappedWatchableObject,
        clazz: Class<T>
    ): Optional<T> {
        return unwrapOptionalValue(wrappedWatchableObject.value as Optional<*>, clazz)
    }

    private fun wrap(
        index: Int,
        value: Any?,
        optional: Boolean,
        clazz: Class<*>
    ): WrappedWatchableObject {
        var newValue = value
        var newClass = clazz
        when (clazz) {
            Component::class.java -> {
                newValue = (value as Component?)?.nms()
                newClass = MinecraftReflection.getIChatBaseComponentClass()
            }

            UmpaEulerAngle::class.java -> {
                newValue = (value as UmpaEulerAngle?)?.nms()
                newClass = Vector3F.getMinecraftClass()
            }

            UmpaBlockPos::class.java -> {
                newValue = (value as UmpaBlockPos?)?.nms()
                newClass = MinecraftReflection.getBlockPositionClass()
            }

            UmpaEntityPose::class.java -> {
                newValue = (value as UmpaEntityPose?)?.nms()
                newClass = EnumWrappers.getEntityPoseClass()
            }

            UmpaCatMetadata.Type::class.java -> {
                newValue = (value as UmpaCatMetadata.Type?)?.let {
                    catVariantRegistry.get(MinecraftKey(it.name.lowercase()))
                }
                newClass = catVariantClass
            }

            UmpaFrogMetadata.Type::class.java -> {
                newValue = (value as UmpaFrogMetadata.Type?)?.let {
                    frogVariantRegistry.get(MinecraftKey(it.name.lowercase()))
                }
                newClass = frogVariantClass
            }

            UmpaPaintingMetadata.Type::class.java -> {
                newValue = (value as UmpaPaintingMetadata.Type?)?.let {
                    paintingVariantRegistry.get(MinecraftKey(it.name.lowercase()))
                }
                newClass = paintingVariantClass
            }
        }
        val registry = WrappedDataWatcher.Registry.get(newClass, optional)
        val wrappedDataWatcherObject = WrappedDataWatcherObject(index, registry)
        return WrappedWatchableObject(
            wrappedDataWatcherObject,
            if (optional) Optional.ofNullable(newValue) else newValue
        )
    }

    private fun <T> unwrapOptionalValue(
        value: Optional<*>,
        clazz: Class<T>
    ): Optional<T> {
        return value.map { unwrapValue(it, clazz) }
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T> unwrapValue(
        value: Any,
        clazz: Class<T>
    ): T {
        return when (clazz) {
            Component::class.java -> (value as WrappedChatComponent).kyori()
            UmpaItemStack::class.java -> (value as ItemStack).umpa()
            UmpaEulerAngle::class.java -> (value as Vector3F).umpaEulerAngle()
            UmpaBlockPos::class.java -> (value as BlockPosition).umpa()
            UmpaDirection::class.java -> (value as EnumWrappers.Direction).umpa()

            UmpaCatMetadata.Type::class.java -> {
                UmpaCatMetadata.Type.valueOf(catVariantRegistry.getKey(value).key.uppercase())
            }

            UmpaFrogMetadata.Type::class.java -> {
                UmpaFrogMetadata.Type.valueOf(frogVariantRegistry.getKey(value).key.uppercase())
            }

            UmpaPaintingMetadata.Type::class.java -> {
                UmpaPaintingMetadata.Type.valueOf(paintingVariantRegistry.getKey(value).key.uppercase())
            }

//            MetaFieldType.OPTIONAL_BLOCK_ID -> TODO()
//            MetaFieldType.NBT -> TODO()
//            MetaFieldType.PARTICLE -> TODO()
//            MetaFieldType.VILLAGER_DATA -> TODO()
//            MetaFieldType.OPTIONAL_INTEGER -> TODO()
//            MetaFieldType.POSE -> TODO()
//            MetaFieldType.GLOBAL_POSITION -> TODO()
            else -> value
        } as T
    }
}