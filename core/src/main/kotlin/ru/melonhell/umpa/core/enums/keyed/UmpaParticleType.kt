package ru.melonhell.umpa.core.enums.keyed

import net.kyori.adventure.key.Key
import java.util.*
import java.util.stream.Collectors

enum class UmpaParticleType(private val stringKey: String) : UmpaKeyed {
    AMBIENT_ENTITY_EFFECT("minecraft:ambient_entity_effect"),
    ANGRY_VILLAGER("minecraft:angry_villager"),
    BLOCK("minecraft:block"),
    BLOCK_MARKER("minecraft:block_marker"),
    BUBBLE("minecraft:bubble"),
    CLOUD("minecraft:cloud"),
    CRIT("minecraft:crit"),
    DAMAGE_INDICATOR("minecraft:damage_indicator"),
    DRAGON_BREATH("minecraft:dragon_breath"),
    DRIPPING_LAVA("minecraft:dripping_lava"),
    FALLING_LAVA("minecraft:falling_lava"),
    LANDING_LAVA("minecraft:landing_lava"),
    DRIPPING_WATER("minecraft:dripping_water"),
    FALLING_WATER("minecraft:falling_water"),
    DUST("minecraft:dust"),
    DUST_COLOR_TRANSITION("minecraft:dust_color_transition"),
    EFFECT("minecraft:effect"),
    ELDER_GUARDIAN("minecraft:elder_guardian"),
    ENCHANTED_HIT("minecraft:enchanted_hit"),
    ENCHANT("minecraft:enchant"),
    END_ROD("minecraft:end_rod"),
    ENTITY_EFFECT("minecraft:entity_effect"),
    EXPLOSION_EMITTER("minecraft:explosion_emitter"),
    EXPLOSION("minecraft:explosion"),
    SONIC_BOOM("minecraft:sonic_boom"),
    FALLING_DUST("minecraft:falling_dust"),
    FIREWORK("minecraft:firework"),
    FISHING("minecraft:fishing"),
    FLAME("minecraft:flame"),
    SCULK_SOUL("minecraft:sculk_soul"),
    SCULK_CHARGE("minecraft:sculk_charge"),
    SCULK_CHARGE_POP("minecraft:sculk_charge_pop"),
    SOUL_FIRE_FLAME("minecraft:soul_fire_flame"),
    SOUL("minecraft:soul"),
    FLASH("minecraft:flash"),
    HAPPY_VILLAGER("minecraft:happy_villager"),
    COMPOSTER("minecraft:composter"),
    HEART("minecraft:heart"),
    INSTANT_EFFECT("minecraft:instant_effect"),
    ITEM("minecraft:item"),
    VIBRATION("minecraft:vibration"),
    ITEM_SLIME("minecraft:item_slime"),
    ITEM_SNOWBALL("minecraft:item_snowball"),
    LARGE_SMOKE("minecraft:large_smoke"),
    LAVA("minecraft:lava"),
    MYCELIUM("minecraft:mycelium"),
    NOTE("minecraft:note"),
    POOF("minecraft:poof"),
    PORTAL("minecraft:portal"),
    RAIN("minecraft:rain"),
    SMOKE("minecraft:smoke"),
    SNEEZE("minecraft:sneeze"),
    SPIT("minecraft:spit"),
    SQUID_INK("minecraft:squid_ink"),
    SWEEP_ATTACK("minecraft:sweep_attack"),
    TOTEM_OF_UNDYING("minecraft:totem_of_undying"),
    UNDERWATER("minecraft:underwater"),
    SPLASH("minecraft:splash"),
    WITCH("minecraft:witch"),
    BUBBLE_POP("minecraft:bubble_pop"),
    CURRENT_DOWN("minecraft:current_down"),
    BUBBLE_COLUMN_UP("minecraft:bubble_column_up"),
    NAUTILUS("minecraft:nautilus"),
    DOLPHIN("minecraft:dolphin"),
    CAMPFIRE_COSY_SMOKE("minecraft:campfire_cosy_smoke"),
    CAMPFIRE_SIGNAL_SMOKE("minecraft:campfire_signal_smoke"),
    DRIPPING_HONEY("minecraft:dripping_honey"),
    FALLING_HONEY("minecraft:falling_honey"),
    LANDING_HONEY("minecraft:landing_honey"),
    FALLING_NECTAR("minecraft:falling_nectar"),
    FALLING_SPORE_BLOSSOM("minecraft:falling_spore_blossom"),
    ASH("minecraft:ash"),
    CRIMSON_SPORE("minecraft:crimson_spore"),
    WARPED_SPORE("minecraft:warped_spore"),
    SPORE_BLOSSOM_AIR("minecraft:spore_blossom_air"),
    DRIPPING_OBSIDIAN_TEAR("minecraft:dripping_obsidian_tear"),
    FALLING_OBSIDIAN_TEAR("minecraft:falling_obsidian_tear"),
    LANDING_OBSIDIAN_TEAR("minecraft:landing_obsidian_tear"),
    REVERSE_PORTAL("minecraft:reverse_portal"),
    WHITE_ASH("minecraft:white_ash"),
    SMALL_FLAME("minecraft:small_flame"),
    SNOWFLAKE("minecraft:snowflake"),
    DRIPPING_DRIPSTONE_LAVA("minecraft:dripping_dripstone_lava"),
    FALLING_DRIPSTONE_LAVA("minecraft:falling_dripstone_lava"),
    DRIPPING_DRIPSTONE_WATER("minecraft:dripping_dripstone_water"),
    FALLING_DRIPSTONE_WATER("minecraft:falling_dripstone_water"),
    GLOW_SQUID_INK("minecraft:glow_squid_ink"),
    GLOW("minecraft:glow"),
    WAX_ON("minecraft:wax_on"),
    WAX_OFF("minecraft:wax_off"),
    ELECTRIC_SPARK("minecraft:electric_spark"),
    SCRAPE("minecraft:scrape"),
    SHRIEK("minecraft:shriek");

    override val key: Key = Key.key(stringKey, ':')

    companion object : UmpaKeyed.Companion<UmpaParticleType> {
        private val keyMap = Arrays.stream(UmpaParticleType.values())
            .collect(Collectors.toMap({ it.stringKey }, { it }))

        @JvmStatic
        override fun fromKey(key: String) = keyMap[key]

        @JvmStatic
        override fun fromKey(key: Key) = fromKey(key.asString())
    }
}