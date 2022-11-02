package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAnimalMetadata

open class UmpaPandaMetadata(
    var unhappyCounter: Int = 0,
    var sneezeCounter: Int = 0,
    var eatCounter: Int = 0,
    var mainGene: Int = 0,
    var hiddenGene: Int = 0,
    var sneezing: Boolean = false,
    var rolling: Boolean = false,
    var sitting: Boolean = false,
    var onBack: Boolean = false,
) : UmpaAnimalMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaPandaMetadata {
        return super.clone() as UmpaPandaMetadata
    }

    companion object {
        private val empty = UmpaPandaMetadata()
    }
}
