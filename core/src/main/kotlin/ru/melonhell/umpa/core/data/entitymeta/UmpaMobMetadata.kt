package ru.melonhell.umpa.core.data.entitymeta

open class UmpaMobMetadata(
    var noAi: Boolean = false,
    var isLeftHanded: Boolean = false,
    var isAggressive: Boolean = false,
) : UmpaLivingEntityMetadata() {
    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaMobMetadata {
        return super.clone() as UmpaMobMetadata
    }

    companion object {
        private val empty = UmpaMobMetadata()
    }
}