package ru.melonhell.umpa.bukkit.wrappers

import com.comphenix.protocol.wrappers.BlockPosition
import com.comphenix.protocol.wrappers.Vector3F
import com.comphenix.protocol.wrappers.WrappedChatComponent
import com.comphenix.protocol.wrappers.WrappedWatchableObject
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer
import ru.melonhell.umpa.bukkit.utils.ProtocolLibUtils
import ru.melonhell.umpa.core.utils.UmpaBlockPos
import ru.melonhell.umpa.core.utils.UmpaEulerAngle
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

class UmpaRawEntityMetadataProtocolLib @JvmOverloads constructor(
    override val handle: MutableMap<Int, WrappedWatchableObject> = HashMap()
) : UmpaRawEntityMetadata() {


    private fun getFlags(id: Int): Byte? = handle[id]?.value as Byte?
    private fun setFlags(id: Int, value: Byte?) {
        if (value == null) handle.remove(id)
        else handle[id] = ProtocolLibUtils.wrapMetaObject(id, value)
    }

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

    fun setFlag(id: Int, flagId: Int, value: Boolean?) {
        if (value != null) setFlags(id, setSharedFlag(getFlags(id) ?: 0, flagId, value))
    }

    fun getFlag(id: Int, flagId: Int): Boolean? {
        return getFlags(id)?.let { getSharedFlag(it, flagId) }
    }

    fun setValue(id: Int, value: Any?) {
        if (value == null) handle.remove(id)
        else handle[id] = ProtocolLibUtils.wrapMetaObject(id, value)
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getRawValue(id: Int): T? {
        return handle[id]?.value as T?
    }

    fun <T> setOptional(id: Int, value: Optional<T>?, clazz: Class<T>) {
        if (value == null) handle.remove(id)
        else handle[id] = ProtocolLibUtils.wrapMetaOptional(id, value.orElse(null), clazz)
    }

    fun getEulerAngle(id: Int): UmpaEulerAngle? {
        return getRawValue<Vector3F>(id)?.let { UmpaEulerAngle(it.x, it.y, it.z) }
    }

    fun getOptionalComponent(id: Int): Optional<Component>? {
        return getRawValue<Optional<WrappedChatComponent>>(id)?.map {
            GsonComponentSerializer.gson().deserialize(it.json)
        }
    }

    fun getOptionalBlockPos(id: Int): Optional<UmpaBlockPos>? {
        return getRawValue<Optional<BlockPosition>>(id)?.map {
            UmpaBlockPos(it.x, it.y, it.z)
        }
    }
}