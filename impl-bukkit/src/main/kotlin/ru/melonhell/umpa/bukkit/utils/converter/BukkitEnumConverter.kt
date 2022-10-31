package ru.melonhell.umpa.bukkit.utils.converter

import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.EntityType
import org.bukkit.inventory.EquipmentSlot
import ru.melonhell.umpa.core.enums.UmpaEquipmentSlot
import ru.melonhell.umpa.core.enums.keyed.UmpaEnchantment
import ru.melonhell.umpa.core.enums.keyed.UmpaEntityType
import ru.melonhell.umpa.core.enums.keyed.UmpaMaterial
import java.util.*
import java.util.stream.Collectors

object BukkitEnumConverter {
    private val bukkitEntityTypes: MutableMap<String, EntityType> = Arrays.stream(EntityType.values())
        .filter { it != EntityType.UNKNOWN }
        .collect(Collectors.toMap({ it.key.toString() }, { it }))

    private val bukkitMaterials: MutableMap<String, Material> = Arrays.stream(Material.values())
        .collect(Collectors.toMap({ it.key.toString() }, { it }))

    private val bukkitEnchantments: MutableMap<String, Enchantment> = Arrays.stream(Enchantment.values())
        .collect(Collectors.toMap({ it.key.toString() }, { it }))

    @JvmStatic
    fun UmpaEntityType.bukkit(): EntityType {
        return bukkitEntityTypes[key.toString()]
            ?: throw RuntimeException("Bukkit EntityType for UmpaEntityType.${name} (${key}) not found")
    }

    @JvmStatic
    fun EntityType.umpa(): UmpaEntityType {
        return UmpaEntityType.fromKey(key.toString())
            ?: throw RuntimeException("UmpaEntityType for Bukkit EntityType.${this.name} (${key}) not found")
    }

    @JvmStatic
    fun UmpaMaterial.bukkit(): Material {
        return bukkitMaterials[key.toString()]
            ?: throw RuntimeException("Bukkit Material for UmpaMaterial.${name} (${key}) not found")
    }

    @JvmStatic
    fun Material.umpa(): UmpaMaterial {
        return UmpaMaterial.fromKey(key.toString())
            ?: throw RuntimeException("UmpaMaterial for Bukkit Material.${name} (${key}) not found")
    }

    @JvmStatic
    fun UmpaEnchantment.bukkit(): Enchantment {
        return bukkitEnchantments[key.toString()]
            ?: throw RuntimeException("Bukkit Enchantment for UmpaEnchantment.${name} (${key}) not found")
    }

    @JvmStatic
    @Suppress("DEPRECATION")
    fun Enchantment.umpa(): UmpaEnchantment {
        return UmpaEnchantment.fromKey(key.toString())
            ?: throw RuntimeException("UmpaEnchantment for Bukkit Enchantment.${name} (${key}) not found")
    }

    @JvmStatic
    fun UmpaEquipmentSlot.bukkit(): EquipmentSlot {
        return when (this) {
            UmpaEquipmentSlot.HAND -> EquipmentSlot.HAND
            UmpaEquipmentSlot.OFF_HAND -> EquipmentSlot.OFF_HAND
            UmpaEquipmentSlot.FEET -> EquipmentSlot.FEET
            UmpaEquipmentSlot.LEGS -> EquipmentSlot.LEGS
            UmpaEquipmentSlot.CHEST -> EquipmentSlot.CHEST
            UmpaEquipmentSlot.HEAD -> EquipmentSlot.HEAD
        }
    }

    @JvmStatic
    fun EquipmentSlot.umpa(): UmpaEquipmentSlot {
        return when (this) {
            EquipmentSlot.HAND -> UmpaEquipmentSlot.HAND
            EquipmentSlot.OFF_HAND -> UmpaEquipmentSlot.OFF_HAND
            EquipmentSlot.FEET -> UmpaEquipmentSlot.FEET
            EquipmentSlot.LEGS -> UmpaEquipmentSlot.LEGS
            EquipmentSlot.CHEST -> UmpaEquipmentSlot.CHEST
            EquipmentSlot.HEAD -> UmpaEquipmentSlot.HEAD
        }
    }
}