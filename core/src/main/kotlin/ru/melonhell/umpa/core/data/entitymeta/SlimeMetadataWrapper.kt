package ru.melonhell.umpa.core.data.entitymeta

class SlimeMetadataWrapper(
    var size: Int = 1
) : MobMetadataWrapper() {
    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): SlimeMetadataWrapper {
        return super.clone() as SlimeMetadataWrapper
    }

    companion object {
        private val empty = SlimeMetadataWrapper()
    }
}