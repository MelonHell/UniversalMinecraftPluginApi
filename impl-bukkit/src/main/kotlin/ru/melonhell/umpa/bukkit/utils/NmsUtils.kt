package ru.melonhell.umpa.bukkit.utils

import com.comphenix.protocol.utility.MinecraftReflection
import org.bukkit.block.data.BlockData
import ru.melonhell.umpa.bukkit.wrappers.UmpaBlockDataBukkit
import ru.melonhell.umpa.core.wrappers.UmpaBlockData

object NmsUtils {
    private var craftBlockDataClass = MinecraftReflection.getCraftBukkitClass("block.data.CraftBlockData")
    private var nmsBlockClass = MinecraftReflection.getBlockClass()
    private var nmsBlockStateClass = MinecraftReflection.getIBlockDataClass()
    private var getStateMethod = craftBlockDataClass.getMethod("getState")
    private var getIdMethod = nmsBlockClass.getMethod("i", nmsBlockStateClass)
    private var getByIdMethod = nmsBlockClass.getMethod("a", Int::class.java)
    private var fromDataMethod = craftBlockDataClass.getMethod("fromData", nmsBlockStateClass)

    @JvmStatic
    fun UmpaBlockData.nms() = (this as UmpaBlockDataBukkit).handle.nms()

    @JvmStatic
    fun blockDataFromNms(nmsBlockState: Any): UmpaBlockDataBukkit =
        UmpaBlockDataBukkit(fromNmsBlockState(nmsBlockState))

    @JvmStatic
    fun BlockData.nms(): Any = getStateMethod.invoke(this)

    @JvmStatic
    fun fromNmsBlockState(nmsBlockState: Any): BlockData = fromDataMethod.invoke(null, nmsBlockState) as BlockData

    @JvmStatic
    fun BlockData.getId(): Int = getIdMethod.invoke(null, this.nms()) as Int

    @JvmStatic
    fun getBlockById(id: Int): BlockData = fromNmsBlockState(getByIdMethod.invoke(null, id))
}