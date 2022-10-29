package ru.melonhell.umpa.bukkit.converter.clientbound.initializeBorder

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.umpa.bukkit.converter.PacketConverter
import ru.melonhell.umpa.bukkit.converter.ProtocolVersion
import ru.melonhell.umpa.bukkit.exceptions.WrongConverterException
import ru.melonhell.umpa.core.enums.WorldBorderAction
import ru.melonhell.umpa.core.protocol.game.clientbound.CbWorldBorderPacketWrapper
import java.util.*

@ProtocolVersion("1.8", "latest")
class InitializeBorderPacketConverter_v1_8_0 : PacketConverter {

    private val actionTypeMap = EnumMap<WorldBorderAction, PacketType>(WorldBorderAction::class.java)
    private val typeActionMap = HashMap<PacketType, WorldBorderAction>()

    init {
        actionTypeMap[WorldBorderAction.INITIALIZE] = PacketType.Play.Server.INITIALIZE_BORDER
        actionTypeMap[WorldBorderAction.SET_CENTER] = PacketType.Play.Server.SET_BORDER_CENTER
        actionTypeMap[WorldBorderAction.SET_LERP_SIZE] = PacketType.Play.Server.SET_BORDER_LERP_SIZE
        actionTypeMap[WorldBorderAction.SET_SIZE] = PacketType.Play.Server.SET_BORDER_SIZE
        actionTypeMap[WorldBorderAction.SET_WARNING_TIME] = PacketType.Play.Server.SET_BORDER_WARNING_DELAY
        actionTypeMap[WorldBorderAction.SET_WARNING_BLOCKS] = PacketType.Play.Server.SET_BORDER_WARNING_DISTANCE
        actionTypeMap.forEach { (t, u) -> typeActionMap[u] = t }
    }

    override fun wrap(container: PacketContainer): CbWorldBorderPacketWrapper {
        val action = typeActionMap[container.type] ?: throw WrongConverterException(container.type, this)
        val wrapper = CbWorldBorderPacketWrapper(action)
        when (action) {
            WorldBorderAction.INITIALIZE -> {
                wrapper.newCenterX = container.doubles.read(0)
                wrapper.newCenterZ = container.doubles.read(1)
                wrapper.oldSize = container.doubles.read(2)
                wrapper.newSize = container.doubles.read(3)
                wrapper.lerpTime = container.longs.read(0)
                wrapper.newAbsoluteMaxSize = container.integers.read(0)
                wrapper.warningBlocks = container.integers.read(1)
                wrapper.warningTime = container.integers.read(2)
            }

            WorldBorderAction.SET_CENTER -> {
                wrapper.newCenterX = container.doubles.read(0)
                wrapper.newCenterZ = container.doubles.read(1)
            }

            WorldBorderAction.SET_LERP_SIZE -> {
                wrapper.oldSize = container.doubles.read(0)
                wrapper.newSize = container.doubles.read(1)
                wrapper.lerpTime = container.longs.read(0)
            }

            WorldBorderAction.SET_SIZE -> {
                wrapper.newSize = container.doubles.read(0)
            }

            WorldBorderAction.SET_WARNING_TIME -> {
                wrapper.warningTime = container.integers.read(0)
            }

            WorldBorderAction.SET_WARNING_BLOCKS -> {
                wrapper.warningBlocks = container.integers.read(0)
            }
        }
        return wrapper
    }

    override fun unwrap(wrapper: ru.melonhell.umpa.core.PacketWrapper): List<PacketContainer> {
        if (wrapper !is CbWorldBorderPacketWrapper) throw WrongConverterException(wrapper, this)
        val packetType = actionTypeMap[wrapper.action] ?: throw WrongConverterException(wrapper, this)
        val container = PacketContainer(packetType)
        when (wrapper.action) {
            WorldBorderAction.INITIALIZE -> {
                container.doubles.write(0, wrapper.newCenterX)
                container.doubles.write(1, wrapper.newCenterZ)
                container.doubles.write(2, wrapper.oldSize)
                container.doubles.write(3, wrapper.newSize)
                container.longs.write(0, wrapper.lerpTime)
                container.integers.write(0, wrapper.newAbsoluteMaxSize)
                container.integers.write(1, wrapper.warningBlocks)
                container.integers.write(2, wrapper.warningTime)
            }

            WorldBorderAction.SET_CENTER -> {
                container.doubles.write(0, wrapper.newCenterX)
                container.doubles.write(1, wrapper.newCenterZ)
            }

            WorldBorderAction.SET_LERP_SIZE -> {
                container.doubles.write(0, wrapper.oldSize)
                container.doubles.write(1, wrapper.newSize)
                container.longs.write(0, wrapper.lerpTime)
            }

            WorldBorderAction.SET_SIZE -> {
                container.doubles.write(0, wrapper.newSize)
            }

            WorldBorderAction.SET_WARNING_TIME -> {
                container.integers.write(0, wrapper.warningTime)
            }

            WorldBorderAction.SET_WARNING_BLOCKS -> {
                container.integers.write(0, wrapper.warningBlocks)
            }
        }
        return listOf(container)
    }

    override val protocolLibTypes = listOf(
        PacketType.Play.Server.INITIALIZE_BORDER,
        PacketType.Play.Server.SET_BORDER_CENTER,
        PacketType.Play.Server.SET_BORDER_LERP_SIZE,
        PacketType.Play.Server.SET_BORDER_SIZE,
        PacketType.Play.Server.SET_BORDER_WARNING_DELAY,
        PacketType.Play.Server.SET_BORDER_WARNING_DISTANCE
    )
    override val wrapperType = CbWorldBorderPacketWrapper::class
}