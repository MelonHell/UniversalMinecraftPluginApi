package ru.melonhell.umpa.bukkit.wrappers

import com.comphenix.protocol.wrappers.WrappedWatchableObject
import ru.melonhell.umpa.core.wrappers.UmpaEntityMetaWrapper

class UmpaEntityMetaWrapperProtocolLib(override val handle: MutableMap<Int, WrappedWatchableObject>) : UmpaEntityMetaWrapper()