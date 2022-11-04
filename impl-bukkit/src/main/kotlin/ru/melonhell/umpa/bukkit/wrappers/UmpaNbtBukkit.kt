package ru.melonhell.umpa.bukkit.wrappers

import ru.melonhell.umpa.core.wrappers.UmpaNbt
import com.comphenix.protocol.wrappers.nbt.NbtCompound

class UmpaNbtBukkit(override val handle: NbtCompound) : UmpaNbt()