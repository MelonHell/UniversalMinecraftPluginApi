package ru.melonhell.umpa.core.data.entitymeta

class UmpaSlimeMetadata(
    var size: Int = 1
) : UmpaMobMetadata() {
    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaSlimeMetadata {
        return super.clone() as UmpaSlimeMetadata
    }

    companion object {
        private val empty = UmpaSlimeMetadata()
    }
}