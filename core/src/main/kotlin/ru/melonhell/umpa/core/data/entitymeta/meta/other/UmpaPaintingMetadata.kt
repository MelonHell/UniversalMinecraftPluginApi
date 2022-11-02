package ru.melonhell.umpa.core.data.entitymeta.meta.other

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaHangingEntityMetadata

open class UmpaPaintingMetadata(
	var paintingVariant: PaintingVariant = PaintingVariant.KEBAB
) : UmpaHangingEntityMetadata() {
		
	override val isEmpty: Boolean
		get() = this == empty

	override fun clone(): UmpaPaintingMetadata {
		return super.clone() as UmpaPaintingMetadata
	}

	companion object {
		private val empty = UmpaPaintingMetadata()
	}

	enum class PaintingVariant(name: String) {
		KEBAB("kebab"),
		AZTEC("aztec"),
		ALBAN("alban"),
		AZTEC2("aztec2"),
		BOMB("bomb"),
		PLANT("plant"),
		WASTELAND("wasteland"),
		POOL("pool"),
		COURBET("courbet"),
		SEA("sea"),
		SUNSET("sunset"),
		CREEBET("creebet"),
		WANDERER("wanderer"),
		GRAHAM("graham"),
		MATCH("match"),
		BUST("bust"),
		STAGE("stage"),
		VOID("void"),
		SKULL_AND_ROSES("skull_and_roses"),
		WITHER("wither"),
		FIGHTERS("fighters"),
		POINTER("pointer"),
		PIGSCENE("pigscene"),
		BURNING_SKULL("burning_skull"),
		SKELETON("skeleton"),
		DONKEY_KONG("donkey_kong"),
		EARTH("earth"),
		WIND("wind"),
		WATER("water"),
		FIRE("fire");
	}
}
