package ru.melonhell.umpa.core.enums.keyed

import net.kyori.adventure.key.Key
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaPlayerMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.*
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.*
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.water.*
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.*
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.raider.*
import ru.melonhell.umpa.core.data.entitymeta.meta.other.*
import ru.melonhell.umpa.core.data.entitymeta.meta.projectile.*
import java.util.*
import java.util.stream.Collectors
import kotlin.reflect.KClass

enum class UmpaEntityType(
    private val stringKey: String,
    private val metaClass: KClass<out UmpaEntityMetadata>
) : UmpaKeyed {
    ALLAY("minecraft:allay", UmpaAllayMetadata::class),
    AREA_EFFECT_CLOUD("minecraft:area_effect_cloud", UmpaAreaEffectCloudMetadata::class),
    ARMOR_STAND("minecraft:armor_stand", UmpaArmorStandMetadata::class),
    ARROW("minecraft:arrow", UmpaArrowMetadata::class),
    AXOLOTL("minecraft:axolotl", UmpaAxolotlMetadata::class),
    BAT("minecraft:bat", UmpaBatMetadata::class),
    BEE("minecraft:bee", UmpaBeeMetadata::class),
    BLAZE("minecraft:blaze", UmpaBlazeMetadata::class),
    BOAT("minecraft:boat", UmpaBoatMetadata::class),
    CHEST_BOAT("minecraft:chest_boat", UmpaChestBoatMetadata::class),
    CAT("minecraft:cat", UmpaCatMetadata::class),
    CAVE_SPIDER("minecraft:cave_spider", UmpaCaveSpiderMetadata::class),
    CHICKEN("minecraft:chicken", UmpaChickenMetadata::class),
    COD("minecraft:cod", UmpaCodMetadata::class),
    COW("minecraft:cow", UmpaCowMetadata::class),
    CREEPER("minecraft:creeper", UmpaCreeperMetadata::class),
    DOLPHIN("minecraft:dolphin", UmpaDolphinMetadata::class),
    DONKEY("minecraft:donkey", UmpaDonkeyMetadata::class),
    DRAGON_FIREBALL("minecraft:dragon_fireball", UmpaDragonFireballMetadata::class),
    DROWNED("minecraft:drowned", UmpaDrownedMetadata::class),
    ELDER_GUARDIAN("minecraft:elder_guardian", UmpaElderGuardianMetadata::class),
    END_CRYSTAL("minecraft:end_crystal", UmpaEndCrystalMetadata::class),
    ENDER_DRAGON("minecraft:ender_dragon", UmpaEnderDragonMetadata::class),
    ENDERMAN("minecraft:enderman", UmpaEndermanMetadata::class),
    ENDERMITE("minecraft:endermite", UmpaEndermiteMetadata::class),
    EVOKER("minecraft:evoker", UmpaEvokerMetadata::class),
    EVOKER_FANGS("minecraft:evoker_fangs", UmpaEvokerFangsMetadata::class),
    EXPERIENCE_ORB("minecraft:experience_orb", UmpaExperienceOrbMetadata::class),
    EYE_OF_ENDER("minecraft:eye_of_ender", UmpaEyeOfEnderMetadata::class),
    FALLING_BLOCK("minecraft:falling_block", UmpaFallingBlockMetadata::class),
    FIREWORK_ROCKET("minecraft:firework_rocket", UmpaFireworkRocketMetadata::class),
    FOX("minecraft:fox", UmpaFoxMetadata::class),
    FROG("minecraft:frog", UmpaFrogMetadata::class),
    GHAST("minecraft:ghast", UmpaGhastMetadata::class),
    GIANT("minecraft:giant", UmpaGiantMetadata::class),
    GLOW_ITEM_FRAME("minecraft:glow_item_frame", UmpaGlowItemFrameMetadata::class),
    GLOW_SQUID("minecraft:glow_squid", UmpaGlowSquidMetadata::class),
    GOAT("minecraft:goat", UmpaGoatMetadata::class),
    GUARDIAN("minecraft:guardian", UmpaGuardianMetadata::class),
    HOGLIN("minecraft:hoglin", UmpaHoglinMetadata::class),
    HORSE("minecraft:horse", UmpaHorseMetadata::class),
    HUSK("minecraft:husk", UmpaHuskMetadata::class),
    ILLUSIONER("minecraft:illusioner", UmpaIllusionerMetadata::class),
    IRON_GOLEM("minecraft:iron_golem", UmpaIronGolemMetadata::class),
    ITEM("minecraft:item", UmpaItemEntityMetadata::class),
    ITEM_FRAME("minecraft:item_frame", UmpaItemFrameMetadata::class),
    FIREBALL("minecraft:fireball", UmpaSmallFireballMetadata::class),
    LEASH_KNOT("minecraft:leash_knot", UmpaLeashKnotMetadata::class),
    LIGHTNING_BOLT("minecraft:lightning_bolt", UmpaLightningBoltMetadata::class),
    LLAMA("minecraft:llama", UmpaLlamaMetadata::class),
    LLAMA_SPIT("minecraft:llama_spit", UmpaLlamaSpitMetadata::class),
    MAGMA_CUBE("minecraft:magma_cube", UmpaMagmaCubeMetadata::class),
    MARKER("minecraft:marker", UmpaMarkerMetadata::class),
    MINECART("minecraft:minecart", UmpaMinecartMetadata::class),
    CHEST_MINECART("minecraft:chest_minecart", UmpaMinecartChestMetadata::class),
    COMMAND_BLOCK_MINECART("minecraft:command_block_minecart", UmpaMinecartCommandBlockMetadata::class),
    FURNACE_MINECART("minecraft:furnace_minecart", UmpaMinecartFurnaceMetadata::class),
    HOPPER_MINECART("minecraft:hopper_minecart", UmpaMinecartHopperMetadata::class),
    SPAWNER_MINECART("minecraft:spawner_minecart", UmpaMinecartSpawnerMetadata::class),
    TNT_MINECART("minecraft:tnt_minecart", UmpaMinecartTntMetadata::class),
    MULE("minecraft:mule", UmpaMuleMetadata::class),
    MOOSHROOM("minecraft:mooshroom", UmpaMooshroomMetadata::class),
    OCELOT("minecraft:ocelot", UmpaOcelotMetadata::class),
    PAINTING("minecraft:painting", UmpaPaintingMetadata::class),
    PANDA("minecraft:panda", UmpaPandaMetadata::class),
    PARROT("minecraft:parrot", UmpaParrotMetadata::class),
    PHANTOM("minecraft:phantom", UmpaPhantomMetadata::class),
    PIG("minecraft:pig", UmpaPigMetadata::class),
    PIGLIN("minecraft:piglin", UmpaPiglinMetadata::class),
    PIGLIN_BRUTE("minecraft:piglin_brute", UmpaPiglinBruteMetadata::class),
    PILLAGER("minecraft:pillager", UmpaPillagerMetadata::class),
    POLAR_BEAR("minecraft:polar_bear", UmpaPolarBearMetadata::class),
    TNT("minecraft:tnt", UmpaPrimedTntMetadata::class),
    PUFFERFISH("minecraft:pufferfish", UmpaPufferfishMetadata::class),
    RABBIT("minecraft:rabbit", UmpaRabbitMetadata::class),
    RAVAGER("minecraft:ravager", UmpaRavagerMetadata::class),
    SALMON("minecraft:salmon", UmpaSalmonMetadata::class),
    SHEEP("minecraft:sheep", UmpaSheepMetadata::class),
    SHULKER("minecraft:shulker", UmpaShulkerMetadata::class),
    SHULKER_BULLET("minecraft:shulker_bullet", UmpaShulkerBulletMetadata::class),
    SILVERFISH("minecraft:silverfish", UmpaSilverfishMetadata::class),
    SKELETON("minecraft:skeleton", UmpaSkeletonMetadata::class),
    SKELETON_HORSE("minecraft:skeleton_horse", UmpaSkeletonHorseMetadata::class),
    SLIME("minecraft:slime", UmpaSlimeMetadata::class),
    SMALL_FIREBALL("minecraft:small_fireball", UmpaSmallFireballMetadata::class),
    SNOW_GOLEM("minecraft:snow_golem", UmpaSnowGolemMetadata::class),
    SNOWBALL("minecraft:snowball", UmpaSnowballMetadata::class),
    SPECTRAL_ARROW("minecraft:spectral_arrow", UmpaSpectralArrowMetadata::class),
    SPIDER("minecraft:spider", UmpaSpiderMetadata::class),
    SQUID("minecraft:squid", UmpaSquidMetadata::class),
    STRAY("minecraft:stray", UmpaStrayMetadata::class),
    STRIDER("minecraft:strider", UmpaStriderMetadata::class),
    TADPOLE("minecraft:tadpole", UmpaTadpoleMetadata::class),
    EGG("minecraft:egg", UmpaThrownEggMetadata::class),
    ENDER_PEARL("minecraft:ender_pearl", UmpaThrownEnderPearlMetadata::class),
    EXPERIENCE_BOTTLE("minecraft:experience_bottle", UmpaThrownExperienceBottleMetadata::class),
    POTION("minecraft:potion", UmpaThrownPotionMetadata::class),
    TRIDENT("minecraft:trident", UmpaThrownTridentMetadata::class),
    TRADER_LLAMA("minecraft:trader_llama", UmpaTraderLlamaMetadata::class),
    TROPICAL_FISH("minecraft:tropical_fish", UmpaTropicalFishMetadata::class),
    TURTLE("minecraft:turtle", UmpaTurtleMetadata::class),
    VEX("minecraft:vex", UmpaVexMetadata::class),
    VILLAGER("minecraft:villager", UmpaVillagerMetadata::class),
    VINDICATOR("minecraft:vindicator", UmpaVindicatorMetadata::class),
    WANDERING_TRADER("minecraft:wandering_trader", UmpaWanderingTraderMetadata::class),
    WARDEN("minecraft:warden", UmpaWardenMetadata::class),
    WITCH("minecraft:witch", UmpaWitchMetadata::class),
    WITHER("minecraft:wither", UmpaWitherBossMetadata::class),
    WITHER_SKELETON("minecraft:wither_skeleton", UmpaWitherSkeletonMetadata::class),
    WITHER_SKULL("minecraft:wither_skull", UmpaWitherSkullMetadata::class),
    WOLF("minecraft:wolf", UmpaWolfMetadata::class),
    ZOGLIN("minecraft:zoglin", UmpaZoglinMetadata::class),
    ZOMBIE("minecraft:zombie", UmpaZombieMetadata::class),
    ZOMBIE_HORSE("minecraft:zombie_horse", UmpaZombieHorseMetadata::class),
    ZOMBIE_VILLAGER("minecraft:zombie_villager", UmpaZombieVillagerMetadata::class),
    ZOMBIFIED_PIGLIN("minecraft:zombified_piglin", UmpaZombifiedPiglinMetadata::class),
    PLAYER("minecraft:player", UmpaPlayerMetadata::class),
    FISHING_BOBBER("minecraft:fishing_bobber", UmpaFishingBobberMetadata::class);

    override val key: Key = Key.key(stringKey, ':')

    companion object : UmpaKeyed.Companion<UmpaEntityType> {
        private val keyMap = Arrays.stream(UmpaEntityType.values())
            .collect(Collectors.toMap({ it.stringKey }, { it }))

        @JvmStatic
        override fun fromKey(key: String) = keyMap[key]

        @JvmStatic
        override fun fromKey(key: Key) = fromKey(key.asString())
    }
}