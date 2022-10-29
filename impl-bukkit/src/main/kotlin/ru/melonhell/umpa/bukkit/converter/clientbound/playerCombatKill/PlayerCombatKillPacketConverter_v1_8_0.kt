package ru.melonhell.umpa.bukkit.converter.clientbound.playerCombatKill

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import com.comphenix.protocol.wrappers.WrappedChatComponent
import net.kyori.adventure.platform.bukkit.MinecraftComponentSerializer
import ru.melonhell.umpa.bukkit.converter.PacketConverter
import ru.melonhell.umpa.bukkit.converter.ProtocolVersion
import ru.melonhell.umpa.bukkit.exceptions.WrongConverterException
import ru.melonhell.umpa.core.protocol.game.clientbound.CbPlayerCombatKillPacketWrapper

@Suppress("UnstableApiUsage")
@ProtocolVersion("1.8", "latest")
class PlayerCombatKillPacketConverter_v1_8_0 : PacketConverter {
    override fun wrap(container: PacketContainer): CbPlayerCombatKillPacketWrapper {
        val playerId = container.integers.read(0)
        val killerId = container.integers.read(1)
        val wrappedChatComponent = container.chatComponents.read(0)
        val message = MinecraftComponentSerializer.get().deserialize(wrappedChatComponent.handle)

        return CbPlayerCombatKillPacketWrapper(playerId, killerId, message)
    }

    override fun unwrap(wrapper: ru.melonhell.umpa.core.PacketWrapper): List<PacketContainer> {
        if (wrapper !is CbPlayerCombatKillPacketWrapper) throw WrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.PLAYER_COMBAT_KILL)
        container.integers.write(0, wrapper.playerId)
        container.integers.write(1, wrapper.killerId)
        container.chatComponents.write(
            0,
            WrappedChatComponent.fromHandle(MinecraftComponentSerializer.get().serialize(wrapper.message))
        )
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Server.PLAYER_COMBAT_KILL)
    override val wrapperType = CbPlayerCombatKillPacketWrapper::class
}