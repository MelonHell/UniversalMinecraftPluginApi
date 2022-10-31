package ru.melonhell.umpa.bukkit.packet.protocollib.converter.serverbound.interactEntity

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import com.comphenix.protocol.wrappers.EnumWrappers
import com.comphenix.protocol.wrappers.WrappedEnumEntityUseAction
import org.bukkit.util.Vector
import ru.melonhell.umpa.bukkit.exceptions.UmpaWrongConverterException
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.PacketConverter
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.ProtocolVersion
import ru.melonhell.umpa.bukkit.utils.converter.BukkitConverter.bukkit
import ru.melonhell.umpa.bukkit.utils.converter.BukkitConverter.umpa
import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.packet.containers.serverbound.UmpaSbInteractEntityPacket
import ru.melonhell.umpa.core.packet.containers.serverbound.UmpaSbInteractEntityPacket.Action
import ru.melonhell.umpa.core.packet.containers.serverbound.UmpaSbInteractEntityPacket.Hand

@ProtocolVersion("1.9", "latest")
class SbInteractEntityPacketConverter_v1_9_0 : PacketConverter {

    private val interactActions = Action.values()
    private val hands = Hand.values()
    private val protocolLibHands = EnumWrappers.Hand.values()

    override fun wrap(container: PacketContainer): UmpaSbInteractEntityPacket {
        val entityId: Int = container.integers.read(0)
        val actionContainer = container.enumEntityUseActions.read(0)
        val action = interactActions[actionContainer.action.ordinal]
        val hand = when (action) {
            Action.INTERACT, Action.INTERACT_AT -> hands[actionContainer.hand.ordinal]
            else -> Hand.MAIN_HAND
        }
        val position = when (action) {
            Action.INTERACT_AT -> actionContainer.position
            else -> Vector()
        }
        val sneaking: Boolean = container.booleans.read(0)
        return UmpaSbInteractEntityPacket(
            entityId,
            action,
            position.umpa(),
            hand,
            sneaking
        )
    }

    override fun unwrap(wrapper: UmpaPacket): List<PacketContainer> {
        if (wrapper !is UmpaSbInteractEntityPacket) throw UmpaWrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Client.USE_ENTITY)
        container.integers.write(0, wrapper.entityId)
        val wrappedEnumEntityUseAction: WrappedEnumEntityUseAction = when (wrapper.action) {
            Action.INTERACT -> WrappedEnumEntityUseAction.interact(protocolLibHands[wrapper.hand.ordinal])
            Action.ATTACK -> WrappedEnumEntityUseAction.attack()
            Action.INTERACT_AT -> WrappedEnumEntityUseAction.interactAt(
                protocolLibHands[wrapper.hand.ordinal],
                wrapper.target.bukkit()
            )
        }
        container.enumEntityUseActions.write(0, wrappedEnumEntityUseAction)
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Client.USE_ENTITY)
    override val packetType = UmpaPacketType.SB_INTERACT_ENTITY
}