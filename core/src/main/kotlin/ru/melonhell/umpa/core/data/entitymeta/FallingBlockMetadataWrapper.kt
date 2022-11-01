package ru.melonhell.umpa.core.data.entitymeta

import ru.melonhell.umpa.core.utils.UmpaBlockPos

class FallingBlockMetadataWrapper(
    var spawnPosition: UmpaBlockPos = UmpaBlockPos()
) : EntityMetadataWrapper() {
    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): FallingBlockMetadataWrapper {
        return super.clone() as FallingBlockMetadataWrapper
    }

    companion object {
        private val empty = FallingBlockMetadataWrapper()
    }
}