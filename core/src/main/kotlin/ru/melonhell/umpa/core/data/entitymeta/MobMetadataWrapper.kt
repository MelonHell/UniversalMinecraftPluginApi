package ru.melonhell.umpa.core.data.entitymeta

open class MobMetadataWrapper(
    var noAi: Boolean = false,
    var isLeftHanded: Boolean = false,
    var isAggressive: Boolean = false,
) : LivingEntityMetadataWrapper() {
    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): MobMetadataWrapper {
        return super.clone() as MobMetadataWrapper
    }

    companion object {
        private val empty = MobMetadataWrapper()
    }
}