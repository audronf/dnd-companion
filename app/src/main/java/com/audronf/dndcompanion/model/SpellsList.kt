package com.audronf.dndcompanion.model

import com.google.gson.annotations.SerializedName

data class SpellsList(
    @SerializedName("index") val index: String,
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)
