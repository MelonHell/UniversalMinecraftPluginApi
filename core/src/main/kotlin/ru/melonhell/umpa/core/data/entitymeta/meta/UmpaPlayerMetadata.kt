package ru.melonhell.umpa.core.data.entitymeta.meta

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaLivingEntityMetadata
import ru.melonhell.umpa.core.wrappers.UmpaNbt
import ru.melonhell.umpa.core.wrappers.UmpaNbtEmpty

open class UmpaPlayerMetadata(
    var playerAbsorption: Float = 0.0F,
    var score: Int = 0,

    var showCape: Boolean = false,
    var showJacket: Boolean = false,
    var showLeftSleeve: Boolean = false,
    var showRightSleeve: Boolean = false,
    var showLeftPantsLeg: Boolean = false,
    var showRightPantsLeg: Boolean = false,
    var showHat: Boolean = false,

    var leftHanded: Boolean = false,
    var shoulderLeft: UmpaNbt = UmpaNbtEmpty(),
    var shoulderRight: UmpaNbt = UmpaNbtEmpty()
) : UmpaLivingEntityMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaPlayerMetadata {
        return super.clone() as UmpaPlayerMetadata
    }

    companion object {
        private val empty = UmpaPlayerMetadata()
    }
}
