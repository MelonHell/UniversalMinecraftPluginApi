package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.water

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractFishMetadata

open class UmpaPufferfishMetadata(
    // TODO сюда тож енум бы хуйнуть
    var puffState: Int = 0
) : UmpaAbstractFishMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaPufferfishMetadata {
        return super.clone() as UmpaPufferfishMetadata
    }

    companion object {
        private val empty = UmpaPufferfishMetadata()
    }
}
