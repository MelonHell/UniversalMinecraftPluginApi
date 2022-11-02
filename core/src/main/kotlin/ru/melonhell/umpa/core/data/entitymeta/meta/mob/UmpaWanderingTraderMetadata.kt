package ru.melonhell.umpa.core.data.entitymeta.meta.mob

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractVillagerMetadata

open class UmpaWanderingTraderMetadata : UmpaAbstractVillagerMetadata() {
    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaWanderingTraderMetadata {
        return super.clone() as UmpaWanderingTraderMetadata
    }

    companion object {
        private val empty = UmpaWanderingTraderMetadata()
    }
}
