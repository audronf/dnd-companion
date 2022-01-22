package com.audronf.dndcompanion.network.service

import com.audronf.dndcompanion.model.Spell
import com.audronf.dndcompanion.model.SpellResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SpellsService {

    @GET("/api/spells")
    suspend fun getSpellsByClass(@Query("class") characterClass: String): Response<SpellResponse>

    @GET("/api/spells/{index}")
    suspend fun getSpellData(@Path("index") index: String): Response<Spell>
}