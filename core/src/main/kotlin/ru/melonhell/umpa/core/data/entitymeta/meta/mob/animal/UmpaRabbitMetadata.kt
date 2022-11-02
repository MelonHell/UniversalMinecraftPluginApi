package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAnimalMetadata

open class UmpaRabbitMetadata(
    var type: Type = Type.BROWN
) : UmpaAnimalMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaRabbitMetadata {
        return super.clone() as UmpaRabbitMetadata
    }

    companion object {
        private val empty = UmpaRabbitMetadata()
    }

    enum class Type {
        /**
         * Chocolate colored rabbit.
         */
        BROWN,

        /**
         * Pure white rabbit.
         */
        WHITE,

        /**
         * Black rabbit.
         */
        BLACK,

        /**
         * Black with white patches, or white with black patches?
         */
        BLACK_AND_WHITE,

        /**
         * Golden bunny.
         */
        GOLD,

        /**
         * Salt and pepper colored, whatever that means.
         */
        SALT_AND_PEPPER,

        /**
         * Rabbit with pure white fur, blood red horizontal eyes, and is hostile to players.
         */
        THE_KILLER_BUNNY
    }
}
