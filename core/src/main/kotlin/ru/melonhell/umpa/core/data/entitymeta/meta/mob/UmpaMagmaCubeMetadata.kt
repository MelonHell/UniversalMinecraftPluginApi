package ru.melonhell.umpa.core.data.entitymeta.meta.mob

open class UmpaMagmaCubeMetadata : UmpaSlimeMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaMagmaCubeMetadata {
        return super.clone() as UmpaMagmaCubeMetadata
    }

    companion object {
        private val empty = UmpaMagmaCubeMetadata()
    }
}
