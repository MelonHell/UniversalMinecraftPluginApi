package ru.melonhell.umpa.core.enums

/**
 * Represents an entity body pose.
 */
enum class UmpaEntityPose {
    /**
     * Entity is standing normally.
     */
    STANDING,

    /**
     * Entity is gliding.
     */
    FALL_FLYING,

    /**
     * Entity is sleeping.
     */
    SLEEPING,

    /**
     * Entity is swimming.
     */
    SWIMMING,

    /**
     * Entity is riptiding with a trident.
     */
    SPIN_ATTACK,

    /**
     * Entity is sneaking.
     */
    SNEAKING,

    /**
     * Entity is long jumping.
     */
    LONG_JUMPING,

    /**
     * Entity is dead.
     */
    DYING,

    /**
     * Entity is croaking.
     */
    CROAKING,

    /**
     * Entity is using its tongue.
     */
    USING_TONGUE,

    /**
     * Entity is roaring.
     */
    ROARING,

    /**
     * Entity is sniffing.
     */
    SNIFFING,

    /**
     * Entity is emerging.
     */
    EMERGING,

    /**
     * Entity is digging.
     */
    DIGGING;
}