package ru.melonhell.umpa.bukkit.converter.serverbound.interact

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import com.comphenix.protocol.wrappers.EnumWrappers
import com.comphenix.protocol.wrappers.WrappedEnumEntityUseAction
import org.bukkit.util.Vector
import ru.melonhell.umpa.bukkit.converter.PacketConverter
import ru.melonhell.umpa.bukkit.converter.ProtocolVersion
import ru.melonhell.umpa.bukkit.exceptions.WrongConverterException
import ru.melonhell.umpa.core.enums.Hand
import ru.melonhell.umpa.core.packet.containers.UmpaPacketContainer
import ru.melonhell.umpa.core.packet.containers.serverbound.UmpaSbInteractEntityPacket
import ru.melonhell.umpa.core.packet.containers.serverbound.UmpaSbInteractEntityPacket.InteractType

@ProtocolVersion("1.9", "latest")
class InteractPacketConverter_v1_9_0 : PacketConverter {

    private val interactActions = InteractType.values()
    private val hands = Hand.values()
    private val protocolLibHands = EnumWrappers.Hand.values()

    override fun wrap(container: PacketContainer): UmpaSbInteractEntityPacket {
        val entityId: Int = container.integers.read(0)
        val actionContainer = container.enumEntityUseActions.read(0)
        val action = interactActions[actionContainer.action.ordinal]
        val hand = when (action) {
            InteractType.INTERACT, InteractType.INTERACT_AT -> hands[actionContainer.hand.ordinal]
            else -> Hand.MAIN_HAND
        }
        val position = when (action) {
            InteractType.INTERACT_AT -> actionContainer.position
            else -> Vector()
        }
        val sneaking: Boolean = container.booleans.read(0)
        return UmpaSbInteractEntityPacket(
            entityId,
            action,
            position.x.toFloat(),
            position.y.toFloat(),
            position.z.toFloat(),
            hand,
            sneaking
        )
    }

    override fun unwrap(wrapper: UmpaPacketContainer): List<PacketContainer> {
        if (wrapper !is UmpaSbInteractEntityPacket) throw WrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Client.USE_ENTITY)
        container.integers.write(0, wrapper.entityId)
        val wrappedEnumEntityUseAction: WrappedEnumEntityUseAction = when (wrapper.type) {
            InteractType.INTERACT -> WrappedEnumEntityUseAction.interact(protocolLibHands[wrapper.hand.ordinal])
            InteractType.ATTACK -> WrappedEnumEntityUseAction.attack()
            InteractType.INTERACT_AT -> WrappedEnumEntityUseAction.interactAt(
                protocolLibHands[wrapper.hand.ordinal],
                Vector(wrapper.targetX, wrapper.targetY, wrapper.targetZ)
            )
        }
        container.enumEntityUseActions.write(0, wrappedEnumEntityUseAction)
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Client.USE_ENTITY)
    override val wrapperType = UmpaSbInteractEntityPacket::class
}