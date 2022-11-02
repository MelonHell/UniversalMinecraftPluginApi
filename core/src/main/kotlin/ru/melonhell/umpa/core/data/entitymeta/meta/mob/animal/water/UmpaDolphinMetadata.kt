package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.water

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaWaterAnimalMetadata
import ru.melonhell.umpa.core.utils.UmpaBlockPos

open class UmpaDolphinMetadata(
    var treasurePos: UmpaBlockPos = UmpaBlockPos(),
    var hasFish: Boolean = false,
    var moistnessLevel: Int = 2400
) : UmpaWaterAnimalMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaDolphinMetadata {
        return super.clone() as UmpaDolphinMetadata
    }

    companion object {
        private val empty = UmpaDolphinMetadata()
    }
}
