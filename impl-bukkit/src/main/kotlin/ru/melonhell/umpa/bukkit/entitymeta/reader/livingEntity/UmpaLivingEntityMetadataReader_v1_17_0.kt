package ru.melonhell.umpa.bukkit.entitymeta.reader.livingEntity

import ru.melonhell.umpa.bukkit.entitymeta.reader.entity.UmpaEntityMetadataReader_v1_17_0
import ru.melonhell.umpa.bukkit.wrappers.UmpaRawEntityMetadataProtocolLib
import ru.melonhell.umpa.core.data.entitymeta.editor.readers.UmpaLivingEntityMetadataReader
import ru.melonhell.umpa.core.enums.UmpaHand
import ru.melonhell.umpa.core.utils.UmpaBlockPos
import java.util.*

open class UmpaLivingEntityMetadataReader_v1_17_0(private val meta: UmpaRawEntityMetadataProtocolLib) :
    UmpaEntityMetadataReader_v1_17_0(meta), UmpaLivingEntityMetadataReader {

    override var handActive: Boolean?
        get() = meta.getFlag(8, 0)
        set(value) = meta.setFlag(8, 0, value)
    override var activeHand: UmpaHand?
        get() = meta.getFlag(8, 1)?.let { if (it) UmpaHand.OFF_HAND else UmpaHand.MAIN_HAND }
        set(value) = meta.setFlag(8, 1, value?.let { it == UmpaHand.OFF_HAND })
    override var isInRiptideSpinAttack: Boolean?
        get() = meta.getFlag(8, 2)
        set(value) = meta.setFlag(8, 2, value)
    override var health: Float?
        get() = meta.getRawValue(9)
        set(value) = meta.setValue(9, value)
    override var potionEffectColor: Int?
        get() = meta.getRawValue(10)
        set(value) = meta.setValue(10, value)
    override var isPotionEffectAmbient: Boolean?
        get() = meta.getRawValue(11)
        set(value) = meta.setValue(11, value)
    override var numberOfArrowsInEntity: Int?
        get() = meta.getRawValue(12)
        set(value) = meta.setValue(12, value)
    override var numberOfBeeStingersInEntity: Int?
        get() = meta.getRawValue(13)
        set(value) = meta.setValue(13, value)
    override var sleepingLocation: Optional<UmpaBlockPos>?
        get() = meta.getOptionalBlockPos(14)
        set(value) = meta.setOptional(14, value, UmpaBlockPos::class.java)
}