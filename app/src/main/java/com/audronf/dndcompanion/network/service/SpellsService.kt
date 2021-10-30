package com.audronf.dndcompanion.network.service

import com.audronf.dndcompanion.model.SpellsList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SpellsService {

    @GET("/spells")
    suspend fun getSpellsByClass(@Query("class") characterClass: String): Response<SpellsList>
}