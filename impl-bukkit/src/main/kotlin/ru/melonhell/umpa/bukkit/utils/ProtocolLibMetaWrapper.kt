package ru.melonhell.umpa.bukkit.utils

import com.comphenix.protocol.utility.MinecraftReflection
import com.comphenix.protocol.wrappers.*
import com.comphenix.protocol.wrappers.WrappedDataWatcher.WrappedDataWatcherObject
import com.comphenix.protocol.wrappers.nbt.NbtCompound
import com.comphenix.protocol.wrappers.nbt.NbtFactory
import net.kyori.adventure.text.Component
import org.bukkit.inventory.ItemStack
import ru.melonhell.umpa.bukkit.utils.NmsUtils.nms
import ru.melonhell.umpa.bukkit.utils.converter.BukkitConverter.umpa
import ru.melonhell.umpa.bukkit.utils.converter.ProtocolLibConverter.kyori
import ru.melonhell.umpa.bukkit.utils.converter.ProtocolLibConverter.nms
import ru.melonhell.umpa.bukkit.utils.converter.ProtocolLibConverter.umpa
import ru.melonhell.umpa.bukkit.utils.converter.ProtocolLibConverter.umpaEulerAngle
import ru.melonhell.umpa.bukkit.utils.converter.ProtocolLibEnumConverter.nms
import ru.melonhell.umpa.bukkit.utils.converter.ProtocolLibEnumConverter.protocolLib
import ru.melonhell.umpa.bukkit.utils.converter.ProtocolLibEnumConverter.umpa
import ru.melonhell.umpa.bukkit.wrappers.UmpaItemStackBukkit
import ru.melonhell.umpa.bukkit.wrappers.UmpaNbtBukkit
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaCatMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaFrogMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaPaintingMetadata
import ru.melonhell.umpa.core.enums.UmpaEntityPose
import ru.melonhell.umpa.core.enums.keyed.UmpaParticleType
import ru.melonhell.umpa.core.utils.UmpaBlockPos
import ru.melonhell.umpa.core.utils.UmpaDirection
import ru.melonhell.umpa.core.utils.UmpaEulerAngle
import ru.melonhell.umpa.core.utils.UmpaVillagerData
import ru.melonhell.umpa.core.wrappers.UmpaBlockData
import ru.melonhell.umpa.core.wrappers.UmpaItemStack
import ru.melonhell.umpa.core.wrappers.UmpaNbt
import java.util.*

object ProtocolLibMetaWrapper {
    private val catVariantClass = MinecraftReflection.getMinecraftClass("world.entity.animal.CatVariant")
    private val catVariantRegistry = WrappedRegistry.getRegistry(catVariantClass)
    private val frogVariantClass = MinecraftReflection.getMinecraftClass("world.entity.animal.FrogVariant")
    private val frogVariantRegistry = WrappedRegistry.getRegistry(frogVariantClass)
    private val paintingVariantClass = MinecraftReflection.getMinecraftClass("world.entity.decoration.PaintingVariant")
    private val paintingVariantRegistry = WrappedRegistry.getRegistry(paintingVariantClass)

    fun <T> wrap(index: Int, value: T, clazz: Class<T>): WrappedWatchableObject {
        return wrap(index, value, false, clazz)
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
        val newValue: Any? = when (clazz) {
            // 0
            Byte::class.java,
                // 1
            Int::class.java,
                // 2
            Float::class.java,
                // 3
            String::class.java -> value
            // 4, 5 (Optional)
            Component::class.java -> (value as Component?)?.nms()
            // 6
            UmpaItemStack::class.java -> (value as UmpaItemStackBukkit?)?.let {
                BukkitConverters.getItemStackConverter().getGeneric(it.handle)
            }
            // 7
            Boolean::class.java -> value
            // 8
            UmpaEulerAngle::class.java -> (value as UmpaEulerAngle?)?.nms()
            // 9, 10 (Optional)
            UmpaBlockPos::class.java -> (value as UmpaBlockPos?)?.nms()
            // 11
            UmpaDirection::class.java -> (value as UmpaDirection?)?.protocolLib()?.let {
                EnumWrappers.getDirectionConverter().getSpecific(it)
            }
            // 12 (Optional)
            UUID::class.java -> value
            // 13
            UmpaBlockData::class.java -> (value as UmpaBlockData?)?.nms()
            // 14
            UmpaNbt::class.java -> if (value is UmpaNbtBukkit) value.handle.handle else NbtFactory.ofCompound(null)
            // 15
            UmpaParticleType::class.java -> TODO("Particle")
            // 16
            UmpaVillagerData::class.java -> TODO("VillagerData")
            // 17
            OptionalInt::class.java -> value
            // 18
            UmpaEntityPose::class.java -> (value as UmpaEntityPose?)?.nms()
            // 19
            UmpaCatMetadata.Type::class.java -> (value as UmpaCatMetadata.Type?)?.let {
                catVariantRegistry.get(MinecraftKey(it.name.lowercase()))
            }
            // 20
            UmpaFrogMetadata.Type::class.java -> (value as UmpaFrogMetadata.Type?)?.let {
                frogVariantRegistry.get(MinecraftKey(it.name.lowercase()))
            }
            // 21 TODO("GlobalPos") maybe unused
            // 22
            UmpaPaintingMetadata.Type::class.java -> (value as UmpaPaintingMetadata.Type?)?.let {
                paintingVariantRegistry.get(MinecraftKey(it.name.lowercase()))
            }

            else -> throw RuntimeException("Unknown meta type ${clazz.name}")
        }

        val newClass: Class<*> = when (clazz) {
            // 0
            Byte::class.java -> clazz
            // 1
            Int::class.java -> clazz
            // 2
            Float::class.java -> clazz
            // 3
            String::class.java -> clazz
            // 4, 5 (Optional)
            Component::class.java -> MinecraftReflection.getIChatBaseComponentClass()
            // 6
            UmpaItemStack::class.java -> MinecraftReflection.getItemStackClass()
            // 7
            Boolean::class.java -> clazz
            // 8
            UmpaEulerAngle::class.java -> Vector3F.getMinecraftClass()
            // 9, 10 (Optional)
            UmpaBlockPos::class.java -> MinecraftReflection.getBlockPositionClass()
            // 11
            UmpaDirection::class.java -> EnumWrappers.getDirectionClass()
            // 12 (Optional)
            UUID::class.java -> clazz
            // 13
            UmpaBlockData::class.java -> MinecraftReflection.getIBlockDataClass()
            // 14
            UmpaNbt::class.java -> MinecraftReflection.getNBTCompoundClass()
            // 15
            UmpaParticleType::class.java -> TODO("Particle")
            // 16
            UmpaVillagerData::class.java -> TODO("VillagerData")
            // 17
            OptionalInt::class.java -> clazz
            // 18
            UmpaEntityPose::class.java -> EnumWrappers.getEntityPoseClass()
            // 19
            UmpaCatMetadata.Type::class.java -> catVariantClass
            // 20
            UmpaFrogMetadata.Type::class.java -> frogVariantClass
            // 21 TODO("GlobalPos") maybe unused
            // 22
            UmpaPaintingMetadata.Type::class.java -> paintingVariantClass
            else -> throw RuntimeException("Unknown meta type ${clazz.name}")
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
            // 0
            Byte::class.java -> value
            // 1
            Int::class.java -> value
            // 2
            Float::class.java -> value
            // 3
            String::class.java -> value
            // 4, 5 (Optional)
            Component::class.java -> (value as WrappedChatComponent).kyori()
            // 6
            UmpaItemStack::class.java -> (value as ItemStack).umpa()
            // 7
            Boolean::class.java -> value
            // 8
            UmpaEulerAngle::class.java -> (value as Vector3F).umpaEulerAngle()
            // 9, 10 (Optional)
            UmpaBlockPos::class.java -> (value as BlockPosition).umpa()
            // 11
            UmpaDirection::class.java -> (value as EnumWrappers.Direction).umpa()
            // 12 (Optional)
            UUID::class.java -> value
            // 13
            UmpaBlockData::class.java -> NmsUtils.blockDataFromNms((value as WrappedBlockData).handle)
            // 14
            UmpaNbt::class.java -> UmpaNbtBukkit(value as NbtCompound)
            // 15
            UmpaParticleType::class.java -> TODO("Particle")
            // 16
            UmpaVillagerData::class.java -> TODO("VillagerData")
            // 17
            OptionalInt::class.java -> value
            // 18
            UmpaEntityPose::class.java -> EnumWrappers.EntityPose.fromNms(value).umpa()
            //19
            UmpaCatMetadata.Type::class.java -> {
                UmpaCatMetadata.Type.valueOf(catVariantRegistry.getKey(value).key.uppercase())
            }
            // 20
            UmpaFrogMetadata.Type::class.java -> {
                UmpaFrogMetadata.Type.valueOf(frogVariantRegistry.getKey(value).key.uppercase())
            }
            // 21
            // TODO("GlobalPos") maybe unused
            // 22
            UmpaPaintingMetadata.Type::class.java -> {
                UmpaPaintingMetadata.Type.valueOf(paintingVariantRegistry.getKey(value).key.uppercase())
            }

            else -> throw RuntimeException("Unknown meta type ${clazz.name}")
        } as T
    }
}