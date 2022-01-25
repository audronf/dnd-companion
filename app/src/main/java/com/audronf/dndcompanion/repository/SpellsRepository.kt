package com.audronf.dndcompanion.repository

import com.audronf.dndcompanion.database.dao.SpellsDao
import com.audronf.dndcompanion.database.entities.SpellEntity
import com.audronf.dndcompanion.network.service.SpellsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class SpellsRepository(
    private val retrofit: Retrofit,
    private val database: SpellsDao
) {
    private val spellsService = retrofit.create(SpellsService::class.java)

    suspend fun getSpells(characterClass: String) = withContext(Dispatchers.IO) {
        spellsService.getSpellsByClass(characterClass)
    }

    suspend fun getSpell(spellIndex: String) = withContext(Dispatchers.IO) {
        spellsService.getSpellData(spellIndex)
    }

    fun saveSpell(spell: SpellEntity) = database.insert(spell)

    fun getSavedSpells(): Flow<List<SpellEntity>> = database.getSpells()
}