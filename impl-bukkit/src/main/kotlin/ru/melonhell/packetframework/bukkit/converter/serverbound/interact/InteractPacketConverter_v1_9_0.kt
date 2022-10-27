package ru.melonhell.packetframework.bukkit.converter.serverbound.interact

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import com.comphenix.protocol.wrappers.EnumWrappers
import com.comphenix.protocol.wrappers.WrappedEnumEntityUseAction
import org.bukkit.util.Vector
import ru.melonhell.packetframework.bukkit.converter.PacketConverter
import ru.melonhell.packetframework.bukkit.converter.ProtocolVersion
import ru.melonhell.packetframework.bukkit.converter.WrongConverterException
import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.protocol.game.serverbound.ServerboundInteractPacketWrapper
import ru.melonhell.packetframework.core.protocol.game.serverbound.ServerboundInteractPacketWrapper.ActionType
import ru.melonhell.packetframework.core.protocol.game.serverbound.ServerboundInteractPacketWrapper.Hand

@ProtocolVersion("1.9", "latest", ServerboundInteractPacketWrapper::class)
class InteractPacketConverter_v1_9_0 : PacketConverter {

    private val actionTypes = ActionType.values()
    private val hands = Hand.values()
    private val protocolLibHands = EnumWrappers.Hand.values()

    override fun wrap(container: PacketContainer): PacketWrapper {
        val entityId: Int = container.integers.read(0)
        val actionContainer = container.enumEntityUseActions.read(0)
        val action = actionTypes[actionContainer.action.ordinal]
        val hand = when (action) {
            ActionType.INTERACT, ActionType.INTERACT_AT -> hands[actionContainer.hand.ordinal]
            else -> Hand.MAIN_HAND
        }
        val position = when (action) {
            ActionType.INTERACT_AT -> actionContainer.position
            else -> Vector()
        }
        val sneaking: Boolean = container.booleans.read(0)
        return ServerboundInteractPacketWrapper(
            entityId,
            action,
            position.x.toFloat(),
            position.y.toFloat(),
            position.z.toFloat(),
            hand,
            sneaking
        )
    }

    override fun unwrap(wrapper: PacketWrapper): List<PacketContainer> {
        if (wrapper !is ServerboundInteractPacketWrapper) throw WrongConverterException(wrapper::class, this::class)
        val container = PacketContainer(PacketType.Play.Client.USE_ENTITY)
        container.integers.write(0, wrapper.entityId)
        val wrappedEnumEntityUseAction: WrappedEnumEntityUseAction = when (wrapper.type) {
            ActionType.INTERACT -> WrappedEnumEntityUseAction.interact(protocolLibHands[wrapper.hand.ordinal])
            ActionType.ATTACK -> WrappedEnumEntityUseAction.attack()
            ActionType.INTERACT_AT -> WrappedEnumEntityUseAction.interactAt(
                protocolLibHands[wrapper.hand.ordinal],
                Vector(wrapper.targetX, wrapper.targetY, wrapper.targetZ)
            )
        }
        container.enumEntityUseActions.write(0, wrappedEnumEntityUseAction)
        return listOf(container)
    }

    override fun getWrapTypes(): Collection<PacketType> {
        return listOf(PacketType.Play.Client.USE_ENTITY)
    }
}