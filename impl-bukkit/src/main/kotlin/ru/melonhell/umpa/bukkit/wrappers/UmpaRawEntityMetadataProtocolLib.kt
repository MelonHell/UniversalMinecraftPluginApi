package ru.melonhell.umpa.bukkit.wrappers

import com.comphenix.protocol.wrappers.WrappedWatchableObject
import ru.melonhell.umpa.bukkit.utils.ProtocolLibMetaWrapper
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

class UmpaRawEntityMetadataProtocolLib @JvmOverloads constructor(
    override val handle: MutableMap<Int, WrappedWatchableObject> = HashMap()
) : UmpaRawEntityMetadata() {
    private fun getSharedFlag(byte: Byte, index: Int): Boolean {
        return byte.toInt() and (1 shl index) != 0
    }

    private fun setSharedFlag(byte: Byte, index: Int, value: Boolean): Byte {
        return if (value) {
            (byte.toInt() or (1 shl index)).toByte()
        } else {
            (byte.toInt() and (1 shl index).inv()).toByte()
        }
    }

    override fun setFlag(id: Int, flagId: Int, value: Boolean?) {
        if (value != null) setValue(id, setSharedFlag(getValue(id, Byte::class.java) ?: 0, flagId, value))
    }

    override fun getFlag(id: Int, flagId: Int): Boolean? {
        return getValue(id, Byte::class.java)?.let { getSharedFlag(it, flagId) }
    }

    override fun <T> getValue(id: Int, clazz: Class<T>): T? {
        return handle[id]?.let { ProtocolLibMetaWrapper.unwrap(it, clazz) }
    }

    override fun setValue(id: Int, value: Any?) {
        if (value == null) handle.remove(id)
        else handle[id] = ProtocolLibMetaWrapper.wrap(id, value)
    }

    override fun <T> getOptional(id: Int, clazz: Class<T>): Optional<T>? {
        return handle[id]?.let { ProtocolLibMetaWrapper.unwrapOptional(it, clazz) }
    }

    override fun <T> setOptional(id: Int, value: Optional<T>?, clazz: Class<T>) {
        if (value == null) handle.remove(id)
        else handle[id] = ProtocolLibMetaWrapper.wrapOptional(id, value, clazz)
    }
}