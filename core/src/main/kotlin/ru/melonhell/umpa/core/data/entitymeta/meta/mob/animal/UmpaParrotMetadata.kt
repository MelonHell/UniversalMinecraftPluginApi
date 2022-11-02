package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaShoulderRidingEntityMetadata

open class UmpaParrotMetadata(
    var type: Type = Type.RED
) : UmpaShoulderRidingEntityMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaParrotMetadata {
        return super.clone() as UmpaParrotMetadata
    }

    companion object {
        private val empty = UmpaParrotMetadata()
    }

    enum class Type {
        /**
         * Classic parrot - red with colored wingtips.
         */
        RED,

        /**
         * Royal blue colored parrot.
         */
        BLUE,

        /**
         * Green colored parrot.
         */
        GREEN,

        /**
         * Cyan colored parrot.
         */
        CYAN,

        /**
         * Gray colored parrot.
         */
        GRAY;
    }
}
