package ru.melonhell.umpa.bukkit.utils

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

    fun toBukkit(umpaEntityType: UmpaEntityType): EntityType {
        return bukkitEntityTypes[umpaEntityType.key.toString()]
            ?: throw RuntimeException("Bukkit EntityType for UmpaEntityType.${umpaEntityType.name} (${umpaEntityType.key}) not found")
    }

    fun fromBukkit(entityType: EntityType): UmpaEntityType {
        return UmpaEntityType.fromKey(entityType.key.toString())
            ?: throw RuntimeException("UmpaEntityType for Bukkit EntityType.${entityType.name} (${entityType.key}) not found")
    }

    fun toBukkit(umpaMaterial: UmpaMaterial): Material {
        return bukkitMaterials[umpaMaterial.key.toString()]
            ?: throw RuntimeException("Bukkit Material for UmpaMaterial.${umpaMaterial.name} (${umpaMaterial.key}) not found")
    }

    fun fromBukkit(material: Material): UmpaMaterial {
        return UmpaMaterial.fromKey(material.key.toString())
            ?: throw RuntimeException("UmpaMaterial for Bukkit Material.${material.name} (${material.key}) not found")
    }

    fun toBukkit(umpaEnchantment: UmpaEnchantment): Enchantment {
        return bukkitEnchantments[umpaEnchantment.key.toString()]
            ?: throw RuntimeException("Bukkit Enchantment for UmpaEnchantment.${umpaEnchantment.name} (${umpaEnchantment.key}) not found")
    }

    @Suppress("DEPRECATION")
    fun fromBukkit(enchantment: Enchantment): UmpaEnchantment {
        return UmpaEnchantment.fromKey(enchantment.key.toString())
            ?: throw RuntimeException("UmpaEnchantment for Bukkit Enchantment.${enchantment.name} (${enchantment.key}) not found")
    }

    fun toBukkit(umpaEquipmentSlot: UmpaEquipmentSlot): EquipmentSlot {
        return when(umpaEquipmentSlot) {
            UmpaEquipmentSlot.HAND -> EquipmentSlot.HAND
            UmpaEquipmentSlot.OFF_HAND -> EquipmentSlot.OFF_HAND
            UmpaEquipmentSlot.FEET -> EquipmentSlot.FEET
            UmpaEquipmentSlot.LEGS -> EquipmentSlot.LEGS
            UmpaEquipmentSlot.CHEST -> EquipmentSlot.CHEST
            UmpaEquipmentSlot.HEAD -> EquipmentSlot.HEAD
        }
    }

    fun fromBukkit(equipmentSlot: EquipmentSlot): UmpaEquipmentSlot {
        return when(equipmentSlot) {
            EquipmentSlot.HAND -> UmpaEquipmentSlot.HAND
            EquipmentSlot.OFF_HAND -> UmpaEquipmentSlot.OFF_HAND
            EquipmentSlot.FEET -> UmpaEquipmentSlot.FEET
            EquipmentSlot.LEGS -> UmpaEquipmentSlot.LEGS
            EquipmentSlot.CHEST -> UmpaEquipmentSlot.CHEST
            EquipmentSlot.HEAD -> UmpaEquipmentSlot.HEAD
        }
    }
}