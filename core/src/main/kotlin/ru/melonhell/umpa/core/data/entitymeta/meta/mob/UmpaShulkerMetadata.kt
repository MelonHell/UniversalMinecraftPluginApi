package ru.melonhell.umpa.core.data.entitymeta.meta.mob

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractGolemMetadata
import ru.melonhell.umpa.core.enums.UmpaDyeColor
import ru.melonhell.umpa.core.utils.UmpaBlockPos
import ru.melonhell.umpa.core.utils.UmpaDirection
import java.util.*

open class UmpaShulkerMetadata(
    var attachFace: UmpaDirection = UmpaDirection.DOWN,
    var attachPos: UmpaBlockPos = UmpaBlockPos(),
    var peek: Int = 0,
    var customColor: Optional<UmpaDyeColor> = Optional.empty() // 16
) : UmpaAbstractGolemMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaShulkerMetadata {
        return super.clone() as UmpaShulkerMetadata
    }

    companion object {
        private val empty = UmpaShulkerMetadata()
    }
}
