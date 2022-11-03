package ru.melonhell.umpa.core.data.entitymeta.meta.vehicle

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata

open class UmpaBoatMetadata(
    var hurt: Int = 0,
    var hurtdir: Int = 1,
    var damage: Float = 0.0F,
    var type: Type = Type.OAK,
    var paddleLeft: Boolean = false,
    var paddleRight: Boolean = false,
    var bubbleTime: Int = 0
) : UmpaEntityMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaBoatMetadata {
        return super.clone() as UmpaBoatMetadata
    }

    companion object {
        private val empty = UmpaBoatMetadata()
    }

    enum class Type {
        OAK,
        SPRUCE,
        BIRCH,
        JUNGLE,
        ACACIA,
        DARK_OAK
    }
}
