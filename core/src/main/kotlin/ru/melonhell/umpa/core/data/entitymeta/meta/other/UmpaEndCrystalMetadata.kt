package ru.melonhell.umpa.core.data.entitymeta.meta.other

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.utils.UmpaBlockPos
import java.util.*

open class UmpaEndCrystalMetadata(
    var beamTarget: Optional<UmpaBlockPos> = Optional.empty(),
    var showBottom: Boolean = true
) : UmpaEntityMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaEndCrystalMetadata {
        return super.clone() as UmpaEndCrystalMetadata
    }

    companion object {
        private val empty = UmpaEndCrystalMetadata()
    }
}
