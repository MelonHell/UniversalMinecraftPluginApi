package ru.melonhell.umpa.bukkit.utils.converter

import org.bukkit.Location
import org.bukkit.World
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.Plugin
import org.bukkit.util.Vector
import ru.melonhell.umpa.bukkit.wrappers.UmpaItemStackBukkit
import ru.melonhell.umpa.bukkit.wrappers.UmpaPlayerBukkit
import ru.melonhell.umpa.bukkit.wrappers.UmpaPluginWrapperBukkit
import ru.melonhell.umpa.bukkit.wrappers.UmpaWorldWrapperBukkit
import ru.melonhell.umpa.core.utils.UmpaEntityLocation
import ru.melonhell.umpa.core.utils.UmpaLook
import ru.melonhell.umpa.core.utils.UmpaVector
import ru.melonhell.umpa.core.wrappers.UmpaItemStack
import ru.melonhell.umpa.core.wrappers.UmpaPlayer
import ru.melonhell.umpa.core.wrappers.UmpaPluginWrapper
import ru.melonhell.umpa.core.wrappers.UmpaWorldWrapper

object BukkitConverter {
    @JvmStatic
    fun UmpaVector.bukkit() = Vector(this.x, this.y, this.z)

    @JvmStatic
    fun Vector.umpa() = UmpaVector(this.x, this.y, this.z)

    @JvmStatic
    fun Location.umpaWorld() = this.world?.umpa()

    @JvmStatic
    fun Location.umpaVector() = UmpaVector(this.x, this.y, this.z)

    @JvmStatic
    fun Location.umpaLook() = UmpaLook(this.yaw, this.pitch)

    @JvmStatic
    fun Location.umpa() = UmpaEntityLocation(this.umpaWorld()!!, this.umpaVector(), this.umpaLook())

    // Wrappers
    @JvmStatic
    fun UmpaItemStack.bukkit() = this.handle as ItemStack

    @JvmStatic
    fun ItemStack.umpa() = UmpaItemStackBukkit(this)

    @JvmStatic
    fun UmpaPlayer.bukkit() = this.handle as Player

    @JvmStatic
    fun Player.umpa() = UmpaPlayerBukkit(this)

    @JvmStatic
    fun UmpaPluginWrapper.bukkit() = this.handle as Plugin

    @JvmStatic
    fun Plugin.umpa() = UmpaPluginWrapperBukkit(this)

    @JvmStatic
    fun UmpaWorldWrapper.bukkit() = this.handle as World

    @JvmStatic
    fun World.umpa() = UmpaWorldWrapperBukkit(this)
}