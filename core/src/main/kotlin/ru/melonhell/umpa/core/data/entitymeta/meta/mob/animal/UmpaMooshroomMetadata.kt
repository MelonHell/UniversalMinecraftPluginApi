package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

open class UmpaMooshroomMetadata(
    var type: Type = Type.RED
) : UmpaCowMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaMooshroomMetadata {
        return super.clone() as UmpaMooshroomMetadata
    }

    companion object {
        private val empty = UmpaMooshroomMetadata()
    }

    enum class Type {
        RED,
        BROWN
    }
}
