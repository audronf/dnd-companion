package com.audronf.dndcompanion.model

import com.google.gson.annotations.SerializedName

data class SpellOverview(
    @SerializedName("index") val index: String,
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
    var spellInfo: Spell
)

data class SpellResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("results") val spellsOverview: List<SpellOverview>,
)

data class Spell(
    @SerializedName("index") val index: String,
    @SerializedName("name") val name: String,
    @SerializedName("desc") val description: Array<String>,
    @SerializedName("higher_level") val higherLevels: Array<String>,
    @SerializedName("range") val range: String,
    @SerializedName("components") val components: Array<String>,
    @SerializedName("material") val material: String?,
    @SerializedName("ritual") val isRitual: Boolean,
)
