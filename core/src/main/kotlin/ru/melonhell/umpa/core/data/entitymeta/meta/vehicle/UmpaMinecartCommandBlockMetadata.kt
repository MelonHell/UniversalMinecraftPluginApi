package ru.melonhell.umpa.core.data.entitymeta.meta.vehicle

import net.kyori.adventure.text.Component
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractMinecartMetadata

open class UmpaMinecartCommandBlockMetadata(
    var commandName: String = "",
    var lastOutput: Component = Component.empty()
) : UmpaAbstractMinecartMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaMinecartCommandBlockMetadata {
        return super.clone() as UmpaMinecartCommandBlockMetadata
    }

    companion object {
        private val empty = UmpaMinecartCommandBlockMetadata()
    }
}
