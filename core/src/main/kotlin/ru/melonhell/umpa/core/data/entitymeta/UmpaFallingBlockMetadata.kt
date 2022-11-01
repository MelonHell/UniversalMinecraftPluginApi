package ru.melonhell.umpa.core.data.entitymeta

import ru.melonhell.umpa.core.utils.UmpaBlockPos

class UmpaFallingBlockMetadata(
    var spawnPosition: UmpaBlockPos = UmpaBlockPos()
) : UmpaEntityMetadata() {
    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaFallingBlockMetadata {
        return super.clone() as UmpaFallingBlockMetadata
    }

    companion object {
        private val empty = UmpaFallingBlockMetadata()
    }
}