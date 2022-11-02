package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

import ru.melonhell.umpa.core.wrappers.UmpaItemStack
import java.util.*

open class UmpaThrowableItemProjectileMetadata(
    var itemStack: Optional<UmpaItemStack> = Optional.empty()
) : UmpaThrowableProjectileMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaThrowableItemProjectileMetadata {
        return super.clone() as UmpaThrowableItemProjectileMetadata
    }

    companion object {
        private val empty = UmpaThrowableItemProjectileMetadata()
    }
}
