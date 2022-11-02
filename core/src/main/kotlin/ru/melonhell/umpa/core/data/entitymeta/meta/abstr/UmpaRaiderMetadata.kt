package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

open class UmpaRaiderMetadata(
    var celebrating: Boolean = false
) : UmpaPatrollingMonsterMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaRaiderMetadata {
        return super.clone() as UmpaRaiderMetadata
    }

    companion object {
        private val empty = UmpaRaiderMetadata()
    }
}
