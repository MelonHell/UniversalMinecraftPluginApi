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

    override fun writeFlag(id: Int, flagId: Int, value: Boolean?) {
        if (value != null) writeValue(id, setSharedFlag(readValue(id, Byte::class.java) ?: 0, flagId, value), Byte::class.java)
    }

    override fun readFlag(id: Int, flagId: Int): Boolean? {
        return readValue(id, Byte::class.java)?.let { getSharedFlag(it, flagId) }
    }

    override fun <T> readValue(id: Int, clazz: Class<T>): T? {
        return handle[id]?.let { ProtocolLibMetaWrapper.unwrap(it, clazz) }
    }

    override fun <T> writeValue(id: Int, value: T?, clazz: Class<T>) {
        if (value == null) handle.remove(id)
        else handle[id] = ProtocolLibMetaWrapper.wrap(id, value, clazz)
    }

    override fun <T> readOptional(id: Int, clazz: Class<T>): Optional<T>? {
        return handle[id]?.let { ProtocolLibMetaWrapper.unwrapOptional(it, clazz) }
    }

    override fun <T> writeOptional(id: Int, value: Optional<T>?, clazz: Class<T>) {
        if (value == null) handle.remove(id)
        else handle[id] = ProtocolLibMetaWrapper.wrapOptional(id, value, clazz)
    }
}